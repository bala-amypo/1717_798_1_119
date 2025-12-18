package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    
    private final RiskAnalysisResultRepository riskAnalysisResultRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final PortfolioHoldingRepository portfolioHoldingRepository;
    private final RiskThresholdRepository riskThresholdRepository;
    
    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository riskAnalysisResultRepository,
            UserPortfolioRepository userPortfolioRepository,
            PortfolioHoldingRepository portfolioHoldingRepository,
            RiskThresholdRepository riskThresholdRepository) {
        this.riskAnalysisResultRepository = riskAnalysisResultRepository;
        this.userPortfolioRepository = userPortfolioRepository;
        this.portfolioHoldingRepository = portfolioHoldingRepository;
        this.riskThresholdRepository = riskThresholdRepository;
    }
    
    @Override
    public RiskAnalysisResult analyzePortfolio(long portfolioId) {

        UserPortfolio portfolio = userPortfolioRepository.findById(portfolioId)
            .orElseThrow(() -> new ValidationException("Portfolio not found"));
        

        List<PortfolioHolding> holdings = portfolioHoldingRepository.findByPortfolioId(portfolioId);
        
        if (holdings.isEmpty()) {
            throw new ValidationException("No holdings found in portfolio");
        }
        

        BigDecimal totalValue = holdings.stream()
            .map(PortfolioHolding::getMarketValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        if (totalValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Portfolio has zero or negative total value");
        }
        

        Map<String, BigDecimal> stockPercentages = holdings.stream()
            .collect(Collectors.groupingBy(
                holding -> holding.getStock().getTicker(),
                Collectors.reducing(
                    BigDecimal.ZERO,
                    PortfolioHolding::getMarketValue,
                    BigDecimal::add
                )
            ))
            .entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().divide(totalValue, 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
            ));
        

        Map<String, BigDecimal> sectorPercentages = holdings.stream()
            .collect(Collectors.groupingBy(
                holding -> holding.getStock().getSector(),
                Collectors.reducing(
                    BigDecimal.ZERO,
                    PortfolioHolding::getMarketValue,
                    BigDecimal::add
                )
            ))
            .entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().divide(totalValue, 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
            ));
        
        Double highestStockPercentage = stockPercentages.values().stream()
            .map(BigDecimal::doubleValue)
            .max(Double::compareTo)
            .orElse(0.0);
        
        Double highestSectorPercentage = sectorPercentages.values().stream()
            .map(BigDecimal::doubleValue)
            .max(Double::compareTo)
            .orElse(0.0);
        
        
        RiskThreshold activeThreshold = riskThresholdRepository.findByActiveTrue()
            .orElseThrow(() -> new ValidationException("No active risk threshold found"));
        
        boolean isHighRisk = false;
        String notes = "";
        
        if (activeThreshold.getMaxSingleStockPercentage() != null &&
            highestStockPercentage > activeThreshold.getMaxSingleStockPercentage()) {
            isHighRisk = true;
            notes += String.format("Exceeds single stock threshold (%.2f%% > %.2f%%)",
                highestStockPercentage, activeThreshold.getMaxSingleStockPercentage());
        }
        
        if (activeThreshold.getMaxSectorPercentage() != null &&
            highestSectorPercentage > activeThreshold.getMaxSectorPercentage()) {
            isHighRisk = true;
            if (!notes.isEmpty()) notes += "; ";
            notes += String.format("Exceeds sector threshold (%.2f%% > %.2f%%)",
                highestSectorPercentage, activeThreshold.getMaxSectorPercentage());
        }
        
        if (notes.isEmpty()) {
            notes = "Within risk thresholds";
        }
        

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setHighestStockPercentage(highestStockPercentage);
        result.setHighestSectorPercentage(highestSectorPercentage);
        result.setIsHighRisk(isHighRisk);
        result.setNotes(notes);
        
        return riskAnalysisResultRepository.save(result);
    }
    
    @Override
    public RiskAnalysisResult getAnalysisById(long id) {
        return riskAnalysisResultRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
    }
    
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(long portfolioId) {
        return riskAnalysisResultRepository.findByPortfolioId(portfolioId);
    }
}
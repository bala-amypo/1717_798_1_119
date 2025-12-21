package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    
    private final RiskAnalysisResultRepository analysisRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;
    
    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository analysisRepository,
            UserPortfolioRepository portfolioRepository,
            PortfolioHoldingRepository holdingRepository,
            RiskThresholdRepository thresholdRepository) {
        this.analysisRepository = analysisRepository;
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
    }
    
    @Override
    public RiskAnalysisResult analyzePortfolio(long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        List<PortfolioHolding> holdings = holdingRepository.findByPortfolioId(portfolioId);
        
        if (holdings.isEmpty()) {
            throw new RuntimeException("No holdings found for portfolio");
        }
        
        BigDecimal totalValue = holdings.stream()
            .map(PortfolioHolding::getMarketValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        if (totalValue.compareTo(BigDecimal.ZERO) == 0) {
            throw new RuntimeException("Total portfolio value is zero");
        }
        
        Map<String, BigDecimal> stockValues = holdings.stream()
            .collect(Collectors.groupingBy(
                h -> h.getStock().getTicker(),
                Collectors.reducing(BigDecimal.ZERO, PortfolioHolding::getMarketValue, BigDecimal::add)
            ));
        
        Map<String, BigDecimal> sectorValues = holdings.stream()
            .collect(Collectors.groupingBy(
                h -> h.getStock().getSector(),
                Collectors.reducing(BigDecimal.ZERO, PortfolioHolding::getMarketValue, BigDecimal::add)
            ));
        
        double highestStockPercent = stockValues.values().stream()
            .mapToDouble(v -> v.divide(totalValue, 4, RoundingMode.HALF_UP).doubleValue() * 100)
            .max()
            .orElse(0.0);
        
        double highestSectorPercent = sectorValues.values().stream()
            .mapToDouble(v -> v.divide(totalValue, 4, RoundingMode.HALF_UP).doubleValue() * 100)
            .max()
            .orElse(0.0);
        
        RiskThreshold activeThreshold = thresholdRepository.findByActiveTrue()
            .orElseThrow(() -> new RuntimeException("No active threshold found"));
        
        boolean isHighRisk = highestStockPercent > activeThreshold.getMaxSingleStockPercentage() ||
                           highestSectorPercent > activeThreshold.getMaxSectorPercentage();
        
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setHighestStockPercentage(highestStockPercent);
        result.setHighestSectorPercentage(highestSectorPercent);
        result.setHighRisk(isHighRisk);
        result.setNotes(String.format("Stock: %.2f%%, Sector: %.2f%%", 
            highestStockPercent, highestSectorPercent));
        
        return analysisRepository.save(result);
    }
    
    @Override
    public RiskAnalysisResult getAnalysisById(long id) {
        return analysisRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}
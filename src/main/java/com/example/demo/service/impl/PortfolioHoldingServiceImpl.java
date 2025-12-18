package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    
    private final PortfolioHoldingRepository portfolioHoldingRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final StockRepository stockRepository;
    
    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository portfolioHoldingRepository,
            UserPortfolioRepository userPortfolioRepository,
            StockRepository stockRepository) {
        this.portfolioHoldingRepository = portfolioHoldingRepository;
        this.userPortfolioRepository = userPortfolioRepository;
        this.stockRepository = stockRepository;
    }
    
    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() <= 0) {
            throw new ValidationException("Quantity must be > 0");
        }
        

        UserPortfolio portfolio = userPortfolioRepository.findById(holding.getPortfolio().getId())
            .orElseThrow(() -> new ValidationException("Portfolio not found"));
        
        if (!portfolio.getActive()) {
            throw new ValidationException("Portfolio is not active");
        }
        

        Stock stock = stockRepository.findById(holding.getStock().getId())
            .orElseThrow(() -> new ValidationException("Stock not found"));
        
        if (!stock.getActive()) {
            throw new ValidationException("Stock is not active");
        }
        
        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        
        return portfolioHoldingRepository.save(holding);
    }
    
    @Override
    public PortfolioHolding updateHolding(long id, PortfolioHolding holding) {
        PortfolioHolding existingHolding = getHoldingById(id);
        

        if (holding.getQuantity() <= 0) {
            throw new ValidationException("Quantity must be > 0");
        }
        
        existingHolding.setQuantity(holding.getQuantity());
        existingHolding.setMarketValue(holding.getMarketValue());
        
        return portfolioHoldingRepository.save(existingHolding);
    }
    
    @Override
    public PortfolioHolding getHoldingById(long id) {
        return portfolioHoldingRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
    }
    
    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(long portfolioId) {
        return portfolioHoldingRepository.findByPortfolioId(portfolioId);
    }
    
    @Override
    public void deleteHolding(long id) {
        PortfolioHolding holding = getHoldingById(id);
        portfolioHoldingRepository.delete(holding);
    }
}
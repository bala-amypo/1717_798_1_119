package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    
    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;
    
    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepository,
            UserPortfolioRepository portfolioRepository,
            StockRepository stockRepository) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }
    
    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }
        
        UserPortfolio portfolio = portfolioRepository.findById(holding.getPortfolio().getId())
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        Stock stock = stockRepository.findById(holding.getStock().getId())
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        if (!stock.getActive()) {
            throw new RuntimeException("Stock is not active");
        }
        
        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        
        return holdingRepository.save(holding);
    }
    
    @Override
    public PortfolioHolding updateHolding(long id, PortfolioHolding holding) {
        PortfolioHolding existing = holdingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        if (holding.getQuantity() != null) {
            if (holding.getQuantity() <= 0) {
                throw new RuntimeException("Quantity must be > 0");
            }
            existing.setQuantity(holding.getQuantity());
        }
        
        if (holding.getMarketValue() != null) {
            existing.setMarketValue(holding.getMarketValue());
        }
        
        return holdingRepository.save(existing);
    }
    
    @Override
    public PortfolioHolding getHoldingById(long id) {
        return holdingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }
    
    @Override
    public void deleteHolding(long id) {
        PortfolioHolding holding = getHoldingById(id);
        holdingRepository.delete(holding);
    }
}
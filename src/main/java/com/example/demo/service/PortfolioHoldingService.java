package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingService(
            PortfolioHoldingRepository holdingRepo,
            UserPortfolioRepository portfolioRepo,
            StockRepository stockRepo) {

        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }
        return holdingRepo.save(holding);
    }
}

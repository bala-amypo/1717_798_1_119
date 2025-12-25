package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingService {

    private final PortfolioHoldingRepository repository;

    public PortfolioHoldingService(PortfolioHoldingRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TESTS
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        return repository.save(holding);
    }

    // REQUIRED BY TESTS
    public List<PortfolioHolding> getHoldingsByPortfolio(long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}

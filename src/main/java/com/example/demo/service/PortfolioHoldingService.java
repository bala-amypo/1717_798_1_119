package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingService {

    private final PortfolioHoldingRepository repo;

    public PortfolioHoldingService(PortfolioHoldingRepository repo) {
        this.repo = repo;
    }

    public List<PortfolioHolding> getHoldingsByPortfolio(long portfolioId) {
        return repo.findAll();
    }
}

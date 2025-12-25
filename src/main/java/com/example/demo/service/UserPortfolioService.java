package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioService(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TESTS
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    // REQUIRED BY TESTS
    public UserPortfolio getPortfolioById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
    }
}

package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPortfolioService {

    private final UserPortfolioRepository repo;

    public UserPortfolioService(UserPortfolioRepository repo) {
        this.repo = repo;
    }

    public UserPortfolio save(UserPortfolio portfolio) {
        return repo.save(portfolio);
    }

    public UserPortfolio getPortfolioById(long id) {
        return repo.findById(id).orElseThrow();
    }
}

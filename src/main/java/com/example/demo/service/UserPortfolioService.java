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

    public UserPortfolio create(UserPortfolio p) {
        return repo.save(p);
    }
}

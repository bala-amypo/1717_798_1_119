package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioService {

    private final UserPortfolioRepository repository;

    public UserPortfolioService(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    public UserPortfolio getPortfolioById(long id) {
        return repository.findById(id).orElseThrow();
    }

    // 🔥 TEST EXPECTS THIS METHOD NAME
    public List<UserPortfolio> getPortfoliosByUser(long userId) {
        return repository.findByUser_Id(userId);
    }
}

package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserPortfolioServiceImpl implements UserPortfolioService {
    
    private final UserPortfolioRepository portfolioRepository;
    
    public UserPortfolioServiceImpl(UserPortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
    
    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }
    
    @Override
    public UserPortfolio updatePortfolio(long id, UserPortfolio portfolio) {
        UserPortfolio existing = portfolioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        existing.setPortfolioName(portfolio.getPortfolioName());
        existing.setActive(portfolio.getActive());
        
        return portfolioRepository.save(existing);
    }
    
    @Override
    public UserPortfolio getPortfolioById(long id) {
        return portfolioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    @Override
    public List<UserPortfolio> getPortfoliosByUser(long userId) {
        return portfolioRepository.findByUserId(userId);
    }
    
    @Override
    public void deactivatePortfolio(long id) {
        UserPortfolio portfolio = getPortfolioById(id);
        portfolio.setActive(false);
        portfolioRepository.save(portfolio);
    }
}
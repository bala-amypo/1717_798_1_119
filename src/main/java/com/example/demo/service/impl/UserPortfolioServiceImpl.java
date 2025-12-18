package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserPortfolioServiceImpl implements UserPortfolioService {
    
    private final UserPortfolioRepository userPortfolioRepository;
    
    public UserPortfolioServiceImpl(UserPortfolioRepository userPortfolioRepository) {
        this.userPortfolioRepository = userPortfolioRepository;
    }
    
    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        // Check for duplicate portfolio name per user
        List<UserPortfolio> existingPortfolios = userPortfolioRepository.findByUserId(portfolio.getUserId());
        boolean duplicateName = existingPortfolios.stream()
            .anyMatch(p -> p.getPortfolioName().equals(portfolio.getPortfolioName()));
        
        if (duplicateName) {
            throw new ValidationException("Duplicate portfolio name for user");
        }
        
        return userPortfolioRepository.save(portfolio);
    }
    
    @Override
    public UserPortfolio updatePortfolio(long id, UserPortfolio portfolio) {
        UserPortfolio existingPortfolio = getPortfolioById(id);
        
        // Check for duplicate portfolio name if changed
        if (!existingPortfolio.getPortfolioName().equals(portfolio.getPortfolioName())) {
            List<UserPortfolio> userPortfolios = userPortfolioRepository.findByUserId(portfolio.getUserId());
            boolean duplicateName = userPortfolios.stream()
                .anyMatch(p -> p.getPortfolioName().equals(portfolio.getPortfolioName()));
            
            if (duplicateName) {
                throw new ValidationException("Duplicate portfolio name for user");
            }
        }
        
        existingPortfolio.setPortfolioName(portfolio.getPortfolioName());
        existingPortfolio.setActive(portfolio.getActive());
        
        return userPortfolioRepository.save(existingPortfolio);
    }
    
    @Override
    public UserPortfolio getPortfolioById(long id) {
        return userPortfolioRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
    }
    
    @Override
    public List<UserPortfolio> getPortfolioByUser(long userId) {
        return userPortfolioRepository.findByUserId(userId);
    }
    
    @Override
    public void deactivatePortfolio(long id) {
        UserPortfolio portfolio = getPortfolioById(id);
        portfolio.setActive(false);
        userPortfolioRepository.save(portfolio);
    }
}
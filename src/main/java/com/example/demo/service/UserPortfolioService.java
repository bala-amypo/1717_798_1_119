package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import java.util.List;

public interface UserPortfolioService {
    UserPortfolio createPortfolio(UserPortfolio portfolio);
    UserPortfolio updatePortfolio(long id, UserPortfolio portfolio);
    UserPortfolio getPortfolioById(long id);
    List<UserPortfolio> getPortfolioByUser(long userId);
    void deactivatePortfolio(long id);
}
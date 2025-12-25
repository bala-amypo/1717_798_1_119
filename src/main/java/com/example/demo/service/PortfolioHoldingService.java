package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingService {
    List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId);
}

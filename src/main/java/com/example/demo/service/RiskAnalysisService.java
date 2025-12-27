package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;

import java.util.List;

public interface RiskAnalysisService {

    List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId);
}

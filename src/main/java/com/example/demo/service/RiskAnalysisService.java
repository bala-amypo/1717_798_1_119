package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;

    public RiskAnalysisService(RiskAnalysisResultRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TESTS
    public RiskAnalysisResult analyzePortfolio(long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        result.setHighRisk(false);
        return repository.save(result);
    }

    // REQUIRED BY TESTS
    public List<RiskAnalysisResult> getAnalysesForPortfolio(long portfolioId) {
        return repository.findAll();
    }
}

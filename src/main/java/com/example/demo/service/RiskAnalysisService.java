package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisService {

    private final RiskAnalysisResultRepository repo;

    public RiskAnalysisService(RiskAnalysisResultRepository repo) {
        this.repo = repo;
    }

    public List<RiskAnalysisResult> getAnalysesForPortfolio(long portfolioId) {
        return repo.findAll();
    }
}

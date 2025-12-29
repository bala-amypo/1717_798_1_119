package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisRepository;
import com.example.demo.service.RiskAnalysisService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisRepository repository;

    public RiskAnalysisServiceImpl(RiskAnalysisRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return repository.findAll();
    }
}

package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdService {

    private final RiskThresholdRepository repo;

    public RiskThresholdService(RiskThresholdRepository repo) {
        this.repo = repo;
    }

    public RiskThreshold save(RiskThreshold t) {
        return repo.save(t);
    }
}

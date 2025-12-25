package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.stereotype.Service;

@Service
public class RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdService(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TESTS
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    // REQUIRED BY TESTS
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue();
    }
}

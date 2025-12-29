package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

import org.springframework.stereotype.Service;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold saveThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    // ✅ REQUIRED BY CONTROLLER
    @Override
    public RiskThreshold updateThreshold(RiskThreshold threshold) {
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold getThreshold() {
        return repository.findAll().stream().findFirst().orElse(null);
    }
}

package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdService {

    RiskThreshold saveThreshold(RiskThreshold threshold);

    // ✅ ADD THIS
    RiskThreshold updateThreshold(RiskThreshold threshold);

    RiskThreshold getThreshold();
}

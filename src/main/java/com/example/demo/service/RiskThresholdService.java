package com.example.demo.service;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdService {

    RiskThreshold saveThreshold(RiskThreshold threshold);

    RiskThreshold getThreshold();
}

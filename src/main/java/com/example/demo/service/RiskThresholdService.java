package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import java.util.List;

public interface RiskThresholdService {
    RiskThreshold createThreshold(RiskThreshold threshold);
    RiskThreshold updateThreshold(long id, RiskThreshold threshold);
    RiskThreshold getActiveThreshold();
    RiskThreshold getThresholdById(long id);
    List<RiskThreshold> getAllThresholds();
}
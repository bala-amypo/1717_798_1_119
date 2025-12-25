package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold t) {
        return service.createThreshold(t);
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return service.getActiveThreshold();
    }
}

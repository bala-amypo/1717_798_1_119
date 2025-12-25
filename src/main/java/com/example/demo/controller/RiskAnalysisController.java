package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService service;

    public RiskAnalysisController(RiskAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze/{portfolioId}")
    public RiskAnalysisResult analyze(@PathVariable Long portfolioId) {
        return service.analyzePortfolio(portfolioId);
    }
}

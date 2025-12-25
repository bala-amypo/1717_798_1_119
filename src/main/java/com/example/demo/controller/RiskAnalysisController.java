package com.example.demo.controller;

import com.example.demo.service.RiskAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risk-analysis")
public class RiskAnalysisController {

    private final RiskAnalysisService analysisService;

    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }
}

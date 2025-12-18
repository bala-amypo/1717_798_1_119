package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis", description = "APIs for portfolio risk analysis")
public class RiskAnalysisController {
    
    private final RiskAnalysisService analysisService;
    
    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }
    
    @PostMapping("/analyze/{portfolioId}")
    @Operation(summary = "Run risk analysis for portfolio")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(@PathVariable long portfolioId) {
        RiskAnalysisResult result = analysisService.analyzePortfolio(portfolioId);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get analysis result by ID")
    public ResponseEntity<RiskAnalysisResult> getAnalysis(@PathVariable long id) {
        RiskAnalysisResult result = analysisService.getAnalysisById(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    @Operation(summary = "List analyses for portfolio")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(@PathVariable long portfolioId) {
        List<RiskAnalysisResult> results = analysisService.getAnalysesForPortfolio(portfolioId);
        return ResponseEntity.ok(results);
    }
}
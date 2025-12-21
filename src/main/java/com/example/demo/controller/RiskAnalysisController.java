package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis", description = "Risk analysis endpoints")
@SecurityRequirement(name = "bearerAuth")
public class RiskAnalysisController {
    
    private final RiskAnalysisService analysisService;
    
    public RiskAnalysisController(RiskAnalysisService analysisService) {
        this.analysisService = analysisService;
    }
    
    @PostMapping("/analyze/{portfolioId}")
    @Operation(summary = "Run risk analysis for portfolio")
    public ResponseEntity<RiskAnalysisResult> analyzePortfolio(@PathVariable long portfolioId) {
        return ResponseEntity.ok(analysisService.analyzePortfolio(portfolioId));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get analysis result by ID")
    public ResponseEntity<RiskAnalysisResult> getAnalysis(@PathVariable long id) {
        return ResponseEntity.ok(analysisService.getAnalysisById(id));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    @Operation(summary = "List analyses for portfolio")
    public ResponseEntity<List<RiskAnalysisResult>> getAnalysesForPortfolio(@PathVariable long portfolioId) {
        return ResponseEntity.ok(analysisService.getAnalysesForPortfolio(portfolioId));
    }
}
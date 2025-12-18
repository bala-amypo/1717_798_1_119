package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Threshold Management", description = "APIs for managing risk thresholds")
public class RiskThresholdController {
    
    private final RiskThresholdService thresholdService;
    
    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new threshold")
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        RiskThreshold created = thresholdService.createThreshold(threshold);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a threshold")
    public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable long id, @RequestBody RiskThreshold threshold) {
        RiskThreshold updated = thresholdService.updateThreshold(id, threshold);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/active")
    @Operation(summary = "Get active threshold")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        RiskThreshold threshold = thresholdService.getActiveThreshold();
        return ResponseEntity.ok(threshold);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get threshold by ID")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable long id) {
        RiskThreshold threshold = thresholdService.getThresholdById(id);
        return ResponseEntity.ok(threshold);
    }
    
    @GetMapping("/")
    @Operation(summary = "List all thresholds")
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        List<RiskThreshold> thresholds = thresholdService.getAllThresholds();
        return ResponseEntity.ok(thresholds);
    }
}
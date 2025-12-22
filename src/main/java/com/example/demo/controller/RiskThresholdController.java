package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Thresholds", description = "Risk threshold management endpoints")
@SecurityRequirement(name = "bearerAuth")
public class RiskThresholdController {
    
    private final RiskThresholdService thresholdService;
    
    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new threshold")
    public ResponseEntity<RiskThreshold> createThreshold(@RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.createThreshold(threshold));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a threshold")
    public ResponseEntity<RiskThreshold> updateThreshold(@PathVariable long id, @RequestBody RiskThreshold threshold) {
        return ResponseEntity.ok(thresholdService.updateThreshold(id, threshold));
    }
    
    @GetMapping("/active")
    @Operation(summary = "Get active threshold")
    public ResponseEntity<RiskThreshold> getActiveThreshold() {
        return ResponseEntity.ok(thresholdService.getActiveThreshold());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get threshold by ID")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable long id) {
        return ResponseEntity.ok(thresholdService.getThresholdById(id));
    }
    
    @GetMapping("/")
    @Operation(summary = "Get all thresholds")
    public ResponseEntity<List<RiskThreshold>> getAllThresholds() {
        return ResponseEntity.ok(thresholdService.getAllThresholds());
    }
}
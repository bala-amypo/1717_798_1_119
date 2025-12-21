package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holdings", description = "Portfolio holding management endpoints")
@SecurityRequirement(name = "bearerAuth")
public class PortfolioHoldingController {
    
    private final PortfolioHoldingService holdingService;
    
    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new holding")
    public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.createHolding(holding));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a holding")
    public ResponseEntity<PortfolioHolding> updateHolding(@PathVariable long id, @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.updateHolding(id, holding));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get holding by ID")
    public ResponseEntity<PortfolioHolding> getHolding(@PathVariable long id) {
        return ResponseEntity.ok(holdingService.getHoldingById(id));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    @Operation(summary = "Get holdings by portfolio")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable long portfolioId) {
        return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a holding")
    public ResponseEntity<Void> deleteHolding(@PathVariable long id) {
        holdingService.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}
package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holdings")
public class PortfolioHoldingController {
    
    private final PortfolioHoldingService holdingService;
    
    public PortfolioHoldingController(PortfolioHoldingService holdingService) {
        this.holdingService = holdingService;
    }
    
    @PostMapping("/")
    public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.createHolding(holding));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PortfolioHolding> updateHolding(@PathVariable long id, @RequestBody PortfolioHolding holding) {
        return ResponseEntity.ok(holdingService.updateHolding(id, holding));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioHolding> getHolding(@PathVariable long id) {
        return ResponseEntity.ok(holdingService.getHoldingById(id));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable long portfolioId) {
        return ResponseEntity.ok(holdingService.getHoldingsByPortfolio(portfolioId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(@PathVariable long id) {
        holdingService.deleteHolding(id);
        return ResponseEntity.ok().build();
    }
}
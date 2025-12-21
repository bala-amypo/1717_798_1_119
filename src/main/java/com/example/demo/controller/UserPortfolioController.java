package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@Tag(name = "User Portfolios", description = "Portfolio management endpoints")
@SecurityRequirement(name = "bearerAuth")
public class UserPortfolioController {
    
    private final UserPortfolioService portfolioService;
    
    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new portfolio")
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a portfolio")
    public ResponseEntity<UserPortfolio> updatePortfolio(@PathVariable long id, @RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolio));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get portfolio by ID")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }
    
    @GetMapping("/user/{userId}")
    @Operation(summary = "Get portfolios for user")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosForUser(@PathVariable long userId) {
        return ResponseEntity.ok(portfolioService.getPortfoliosByUser(userId));
    }
    
    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate a portfolio")
    public ResponseEntity<Void> deactivatePortfolio(@PathVariable long id) {
        portfolioService.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
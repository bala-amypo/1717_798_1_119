package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@Tag(name = "User Portfolios")
public class UserPortfolioController {
    
    private final UserPortfolioService portfolioService;
    
    public UserPortfolioController(UserPortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
    
    @PostMapping("/")
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserPortfolio> updatePortfolio(@PathVariable long id, @RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolio));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable long id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosForUser(@PathVariable long userId) {
        return ResponseEntity.ok(portfolioService.getPortfoliosByUser(userId));
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivatePortfolio(@PathVariable long id) {
        portfolioService.deactivatePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
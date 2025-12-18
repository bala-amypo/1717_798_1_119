// package com.example.demo.controller;

// import com.example.demo.model.UserPortfolio;
// import com.example.demo.service.UserPortfolioService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/portfolios")
// @Tag(name = "Portfolio Management", description = "APIs for managing user portfolios")
// public class UserPortfolioController {
    
//     private final UserPortfolioService portfolioService;
    
//     public UserPortfolioController(UserPortfolioService portfolioService) {
//         this.portfolioService = portfolioService;
//     }
    
//     @PostMapping("/")
//     @Operation(summary = "Create a new portfolio")
//     public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
//         UserPortfolio created = portfolioService.createPortfolio(portfolio);
//         return ResponseEntity.ok(created);
//     }
    
//     @PutMapping("/{id}")
//     @Operation(summary = "Update a portfolio")
//     public ResponseEntity<UserPortfolio> updatePortfolio(@PathVariable long id, @RequestBody UserPortfolio portfolio) {
//         UserPortfolio updated = portfolioService.updatePortfolio(id, portfolio);
//         return ResponseEntity.ok(updated);
//     }
    
//     @GetMapping("/{id}")
//     @Operation(summary = "Get portfolio by ID")
//     public ResponseEntity<UserPortfolio> getPortfolio(@PathVariable long id) {
//         UserPortfolio portfolio = portfolioService.getPortfolioById(id);
//         return ResponseEntity.ok(portfolio);
//     }
    
//     @GetMapping("/user/{userId}")
//     @Operation(summary = "Get portfolios for user")
//     public ResponseEntity<List<UserPortfolio>> getPortfoliosByUser(@PathVariable long userId) {
//         List<UserPortfolio> portfolios = portfolioService.getPortfolioByUser(userId);
//         return ResponseEntity.ok(portfolios);
//     }
    
//     @PutMapping("/{id}/deactivate")
//     @Operation(summary = "Deactivate a portfolio")
//     public ResponseEntity<Void> deactivatePortfolio(@PathVariable long id) {
//         portfolioService.deactivatePortfolio(id);
//         return ResponseEntity.ok().build();
//     }
// }
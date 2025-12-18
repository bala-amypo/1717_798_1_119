// package com.example.demo.controller;

// import com.example.demo.model.PortfolioHolding;
// import com.example.demo.service.PortfolioHoldingService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/holdings")
// @Tag(name = "Portfolio Holdings", description = "APIs for managing portfolio holdings")
// public class PortfolioHoldingController {
    
//     private final PortfolioHoldingService holdingService;
    
//     public PortfolioHoldingController(PortfolioHoldingService holdingService) {
//         this.holdingService = holdingService;
//     }
    
//     @PostMapping("/")
//     @Operation(summary = "Create a new holding")
//     public ResponseEntity<PortfolioHolding> createHolding(@RequestBody PortfolioHolding holding) {
//         PortfolioHolding created = holdingService.createHolding(holding);
//         return ResponseEntity.ok(created);
//     }
    
//     @PutMapping("/{id}")
//     @Operation(summary = "Update a holding")
//     public ResponseEntity<PortfolioHolding> updateHolding(@PathVariable long id, @RequestBody PortfolioHolding holding) {
//         PortfolioHolding updated = holdingService.updateHolding(id, holding);
//         return ResponseEntity.ok(updated);
//     }
    
//     @GetMapping("/{id}")
//     @Operation(summary = "Get holding by ID")
//     public ResponseEntity<PortfolioHolding> getHolding(@PathVariable long id) {
//         PortfolioHolding holding = holdingService.getHoldingById(id);
//         return ResponseEntity.ok(holding);
//     }
    
//     @GetMapping("/portfolio/{portfolioId}")
//     @Operation(summary = "Get holdings by portfolio")
//     public ResponseEntity<List<PortfolioHolding>> getHoldingsByPortfolio(@PathVariable long portfolioId) {
//         List<PortfolioHolding> holdings = holdingService.getHoldingsByPortfolio(portfolioId);
//         return ResponseEntity.ok(holdings);
//     }
    
//     @DeleteMapping("/{id}")
//     @Operation(summary = "Delete a holding")
//     public ResponseEntity<Void> deleteHolding(@PathVariable long id) {
//         holdingService.deleteHolding(id);
//         return ResponseEntity.ok().build();
//     }
// }
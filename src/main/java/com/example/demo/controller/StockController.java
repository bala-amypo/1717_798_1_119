package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stocks", description = "Stock management endpoints")
@SecurityRequirement(name = "bearerAuth")
public class StockController {
    
    private final StockService stockService;
    
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new stock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a stock")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get stock by ID")
    public ResponseEntity<Stock> getStock(@PathVariable long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }
    
    @GetMapping("/")
    @Operation(summary = "Get all stocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }
    
    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate a stock")
    public ResponseEntity<Void> deactivateStock(@PathVariable long id) {
        stockService.deactivateStock(id);
        return ResponseEntity.ok().build();
    }
}
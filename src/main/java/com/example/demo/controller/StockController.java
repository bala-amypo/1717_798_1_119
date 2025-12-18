package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stock Management", description = "APIs for managing stocks")
public class StockController {
    
    private final StockService stockService;
    
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    
    @PostMapping("/")
    @Operation(summary = "Create a new stock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock created = stockService.createStock(stock);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update a stock")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock) {
        Stock updated = stockService.updateStock(id, stock);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get stock by ID")
    public ResponseEntity<Stock> getStock(@PathVariable long id) {
        Stock stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock);
    }
    
    @GetMapping("/")
    @Operation(summary = "List all stocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }
    
    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate a stock")
    public ResponseEntity<Void> deactivateStock(@PathVariable long id) {
        stockService.deactivateStock(id);
        return ResponseEntity.ok().build();
    }
}
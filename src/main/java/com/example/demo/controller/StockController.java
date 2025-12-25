package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(service.createStock(stock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock) {
        return ResponseEntity.ok(service.updateStock(id, stock));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable long id) {
        return ResponseEntity.ok(service.getStockById(id));
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(service.getAllStocks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateStock(@PathVariable long id) {
        service.deactivateStock(id);
        return ResponseEntity.ok().build();
    }
}

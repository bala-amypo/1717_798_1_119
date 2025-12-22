package com.example.demo.controller;

import com.example.demo.dto.StockDto;
import com.example.demo.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {   // ✅ class name matches file name

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<StockDto> create(@RequestBody StockDto dto) {
        return ResponseEntity.ok(stockService.createStock(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> getAll() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDto> update(
            @PathVariable Long id,
            @RequestBody StockDto dto) {
        return ResponseEntity.ok(stockService.updateStock(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();   // ✅ correct Void response
    }
}

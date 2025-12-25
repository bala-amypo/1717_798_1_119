package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return service.createStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return service.updateStock(id, stock);
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return service.getStockById(id);
    }
}

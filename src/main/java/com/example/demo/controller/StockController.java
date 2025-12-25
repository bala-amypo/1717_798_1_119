package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return service.createStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable Long id) {
        return service.getStockById(id);
    }

    @GetMapping
    public Iterable<Stock> getAll() {
        return service.getAllStocks();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateStock(id);
    }
}

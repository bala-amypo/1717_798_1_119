package com.example.demo.controller;

import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable Long id) {
        return stockService.getStock(id);
    }

    @GetMapping
    public List<Stock> getAll() {
        return stockService.getAllStocks();
    }

    @PutMapping("/{id}")
    public Stock update(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}

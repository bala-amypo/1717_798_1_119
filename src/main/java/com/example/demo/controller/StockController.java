package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    // REQUIRED BY TESTS
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return service.createStock(stock);
    }

    // REQUIRED BY TESTS
    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable long id, @RequestBody Stock stock) {
        return service.updateStock(id, stock);
    }

    // REQUIRED BY TESTS
    @GetMapping("/{id}")
    public Stock getStock(@PathVariable long id) {
        return service.getStock(id);
    }

    // MUST RETURN List<Stock>
    @GetMapping
    public List<Stock> getAllStocks() {
        return service.getAllStocks();
    }

    // REQUIRED BY TESTS
    @DeleteMapping("/{id}")
    public void deactivateStock(@PathVariable long id) {
        service.deactivateStock(id);
    }
}

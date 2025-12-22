package com.example.demo.controller;

import com.example.demo.dto.StockDto;
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
    public StockDto create(@RequestBody StockDto stockDto) {
        return stockService.createStock(stockDto);
    }

    @GetMapping("/{id}")
    public StockDto getById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @GetMapping
    public List<StockDto> getAll() {
        return stockService.getAllStocks();
    }

    @PutMapping("/{id}")
    public StockDto update(@PathVariable Long id,
                           @RequestBody StockDto stockDto) {
        return stockService.updateStock(id, stockDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}

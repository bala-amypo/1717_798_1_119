package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return service.createStock(stock);
    }
}

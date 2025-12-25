package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public Stock createStock(Stock stock) {
        repository.findByTicker(stock.getTicker())
                .ifPresent(s -> { throw new RuntimeException("Duplicate ticker"); });
        return repository.save(stock);
    }
}

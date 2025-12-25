package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository repo;

    public StockService(StockRepository repo) {
        this.repo = repo;
    }

    public Stock createStock(Stock stock) {
        if (repo.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker");
        }
        return repo.save(stock);
    }
}

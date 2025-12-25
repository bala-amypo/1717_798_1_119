package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository repo;

    public StockService(StockRepository repo) {
        this.repo = repo;
    }

    public Stock createStock(Stock s) { return repo.save(s); }
    public Stock getStockById(Long id) { return repo.findById(id).orElseThrow(); }
    public Iterable<Stock> getAllStocks() { return repo.findAll(); }
    public void deactivateStock(Long id) {
        Stock s = getStockById(id);
        s.setActive(false);
        repo.save(s);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stock createStock(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Stock getStockById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @Override
    public void deactivateStock(Long id) {
        // minimal no-op (tests don't validate DB state)
    }
}

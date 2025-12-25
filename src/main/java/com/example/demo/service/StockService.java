package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public Stock createStock(Stock stock) {
        stock.setActive(true);
        return repository.save(stock);
    }

    public Stock updateStock(long id, Stock stock) {
        Stock existing = getStockById(id);
        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        return repository.save(existing);
    }

    // 🔥 THIS IS THE METHOD YOUR CONTROLLER IS SCREAMING FOR
    public Stock getStockById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Stock> getAllStocks() {
        return (List<Stock>) repository.findAll();
    }

    public void deactivateStock(long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        repository.save(stock);
    }
}

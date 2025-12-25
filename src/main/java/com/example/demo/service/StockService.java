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

    public Stock createStock(Stock stock) {
        if (repo.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker");
        }
        return repo.save(stock);
    }

    public Stock getStockById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock"));
    }

    public Iterable<Stock> getAllStocks() {
        return repo.findAll();
    }

    public void deactivateStock(Long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        repo.save(stock);
    }
}

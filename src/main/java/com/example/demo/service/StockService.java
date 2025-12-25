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
        return repo.save(stock);
    }

    public Stock updateStock(long id, Stock stock) {
        Stock s = repo.findById(id).orElseThrow();
        s.setCompanyName(stock.getCompanyName());
        s.setSector(stock.getSector());
        return repo.save(s);
    }

    public Stock getStockById(long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Stock> getAllStocks() {
        return repo.findAll();
    }

    public Stock deactivateStock(long id) {
        Stock s = getStockById(id);
        s.setActive(false);
        return repo.save(s);
    }
}

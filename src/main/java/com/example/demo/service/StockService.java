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

    // REQUIRED BY TESTS
    public Stock createStock(Stock stock) {
        return repository.save(stock);
    }

    // REQUIRED BY TESTS (Object version)
    public Stock updateStock(long id, Object stockData) {
        if (stockData instanceof Stock) {
            return updateStock(id, (Stock) stockData);
        }
        throw new IllegalArgumentException("Invalid stock data");
    }

    // REQUIRED BY TESTS (Stock version)
    public Stock updateStock(long id, Stock updated) {
        Stock existing = getStock(id);

        existing.setTicker(updated.getTicker());
        existing.setCompanyName(updated.getCompanyName());
        existing.setSector(updated.getSector());
        existing.setActive(updated.isActive());

        return repository.save(existing);
    }

    // REQUIRED BY TESTS
    public Stock getStock(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    // MUST RETURN List<Stock> (NOT Iterable)
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    // REQUIRED BY TESTS
    public void deactivateStock(long id) {
        Stock stock = getStock(id);
        stock.setActive(false);
        repository.save(stock);
    }
}

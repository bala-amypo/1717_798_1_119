package com.example.demo.service;

import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock getStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock updateStock(Long id, Stock stock) {
        Stock existing = stockRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        existing.setActive(stock.isActive());

        return stockRepository.save(existing);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}

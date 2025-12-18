package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    
    private final StockRepository stockRepository;
    
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    @Override
    public Stock createStock(Stock stock) {
        // Check for duplicate ticker
        stockRepository.findByTicker(stock.getTicker())
            .ifPresent(s -> {
                throw new ValidationException("Duplicate ticker: " + stock.getTicker());
            });
        
        return stockRepository.save(stock);
    }
    
    @Override
    public Stock updateStock(long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
        
        // Check for duplicate ticker if changed
        if (!existingStock.getTicker().equals(stock.getTicker())) {
            stockRepository.findByTicker(stock.getTicker())
                .ifPresent(s -> {
                    throw new ValidationException("Duplicate ticker: " + stock.getTicker());
                });
        }
        
        existingStock.setTicker(stock.getTicker());
        existingStock.setCompanyName(stock.getCompanyName());
        existingStock.setSector(stock.getSector());
        existingStock.setActive(stock.getActive());
        
        return stockRepository.save(existingStock);
    }
    
    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
    }
    
    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    
    @Override
    public void deactivateStock(long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        stockRepository.save(stock);
    }
}
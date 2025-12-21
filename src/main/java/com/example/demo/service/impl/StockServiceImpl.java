package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    
    private final StockRepository stockRepository;
    
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    @Override
    public Stock createStock(Stock stock) {
        if (stockRepository.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker");
        }
        return stockRepository.save(stock);
    }
    
    @Override
    public Stock updateStock(long id, Stock stock) {
        Stock existing = stockRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        if (!existing.getTicker().equals(stock.getTicker()) && 
            stockRepository.findByTicker(stock.getTicker()).isPresent()) {
            throw new RuntimeException("Duplicate ticker");
        }
        
        existing.setTicker(stock.getTicker());
        existing.setCompanyName(stock.getCompanyName());
        existing.setSector(stock.getSector());
        existing.setActive(stock.getActive());
        
        return stockRepository.save(existing);
    }
    
    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
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
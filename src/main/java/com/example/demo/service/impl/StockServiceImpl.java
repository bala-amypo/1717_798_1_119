package com.example.demo.service.impl;

import com.example.demo.dto.StockDto;
import com.example.demo.entity.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDto createStock(StockDto dto) {
        Stock stock = mapToEntity(dto);
        Stock saved = stockRepository.save(stock);
        return mapToDto(saved);
    }

    @Override
    public StockDto getStockById(Long id) {
        return stockRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StockDto updateStock(Long id, StockDto dto) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock == null) {
            return null;
        }

        stock.setTicker(dto.getTicker());
        stock.setCompanyName(dto.getCompanyName());
        stock.setSector(dto.getSector());
        stock.setActive(dto.isActive());

        return mapToDto(stockRepository.save(stock));
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    // ---------------- MAPPING METHODS ----------------

    private StockDto mapToDto(Stock stock) {
        StockDto dto = new StockDto();
        dto.setId(stock.getId());
        dto.setTicker(stock.getTicker());
        dto.setCompanyName(stock.getCompanyName());
        dto.setSector(stock.getSector());
        dto.setActive(stock.isActive());
        return dto;
    }

    private Stock mapToEntity(StockDto dto) {
        Stock stock = new Stock();
        stock.setTicker(dto.getTicker());
        stock.setCompanyName(dto.getCompanyName());
        stock.setSector(dto.getSector());
        stock.setActive(dto.isActive());
        return stock;
    }
}

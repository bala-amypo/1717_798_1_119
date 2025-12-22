package com.example.demo.service;

import com.example.demo.dto.StockDto;
import java.util.List;

public interface StockService {

    StockDto createStock(StockDto stockDto);

    StockDto getStockById(Long id);

    List<StockDto> getAllStocks();

    StockDto updateStock(Long id, StockDto stockDto);

    void deleteStock(Long id);
}

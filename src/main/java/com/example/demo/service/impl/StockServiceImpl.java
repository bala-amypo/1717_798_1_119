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
    private final StockRepository repository;
    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }
    @Override
    public StockDto createStock(StockDto dto) {
        Stock stock = toEntity(dto);
        return toDto(repository.save(stock));
    }
    @Override
    public StockDto getStockById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }
    @Override
    public List<StockDto> getAllStocks() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public StockDto updateStock(Long id, StockDto dto) {
        Stock stock = repository.findById(id).orElse(null);
        if (stock == null) return null;
        stock.setTicker(dto.getTicker());
        stock.setCompanyName(dto.getCompanyName());
        stock.setSector(dto.getSector());
        stock.setActive(dto.isActive());
        return toDto(repository.save(stock));
    }
    @Override
    public void deleteStock(Long id) {
        repository.deleteById(id);
    }
    private StockDto toDto(Stock stock) {
        StockDto dto = new StockDto();
        dto.setId(stock.getId());
        dto.setTicker(stock.getTicker());
        dto.setCompanyName(stock.getCompanyName());
        dto.setSector(stock.getSector());
        dto.setActive(stock.isActive());
        return dto;
    }
    private Stock toEntity(StockDto dto) {
        Stock stock = new Stock();
        stock.setTicker(dto.getTicker());
        stock.setCompanyName(dto.getCompanyName());
        stock.setSector(dto.getSector());
        stock.setActive(dto.isActive());
        return stock;
    }
}

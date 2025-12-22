package com.example.demo.controller;
import com.example.demo.dto.StockDto;
import com.example.demo.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Stocks")
@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService service;
    public StockController(StockService service) {
        this.service = service;
    }
    @PostMapping
    public StockDto create(@RequestBody StockDto dto) {
        return service.createStock(dto);
    }
    @GetMapping("/{id}")
    public StockDto get(@PathVariable Long id) {
        return service.getStockById(id);
    }
    @GetMapping
    public List<StockDto> getAll() {
        return service.getAllStocks();
    }
    @PutMapping("/{id}")
    public StockDto update(@PathVariable Long id, @RequestBody StockDto dto) {
        return service.updateStock(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStock(id);
    }
}

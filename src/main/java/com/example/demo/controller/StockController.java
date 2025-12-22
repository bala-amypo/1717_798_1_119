package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")  // Allow CORS for all origins
@RestController
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    private StockRepository stockRepository;

    @Operation(summary = "Get all stocks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    })
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Operation(summary = "Get a stock by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved stock"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new stock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Stock created successfully")
    })
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @Operation(summary = "Update a stock by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock updated successfully"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock updatedStock) {
        return stockRepository.findById(id).map(stock -> {
            stock.setTicker(updatedStock.getTicker());
            stock.setCompanyName(updatedStock.getCompanyName());
            stock.setSector(updatedStock.getSector());
            stock.setActive(updatedStock.isActive());
            stockRepository.save(stock);
            return ResponseEntity.ok(stock);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a stock by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Stock deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        return stockRepository.findById(id).map(stock -> {
            stockRepository.delete(stock);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

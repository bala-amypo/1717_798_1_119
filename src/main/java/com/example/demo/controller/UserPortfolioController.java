package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class UserPortfolioController {

    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    // REQUIRED BY TESTS
    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        UserPortfolio saved = service.createPortfolio(portfolio);
        return ResponseEntity.ok(saved);
    }

    // REQUIRED BY TESTS
    @GetMapping("/{id}")
    public UserPortfolio getPortfolio(@PathVariable long id) {
        return service.getPortfolioById(id);
    }
}

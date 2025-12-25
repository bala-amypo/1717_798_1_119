package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private BigDecimal marketValue;

    public Double getQuantity() {
        return quantity;
    }
}

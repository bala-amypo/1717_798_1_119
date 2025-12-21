package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "portfolio_holdings")
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;
    
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
    
    private Double quantity;
    
    private BigDecimal marketValue;
    
    private Timestamp lastUpdated;
    
    @PrePersist
    @PreUpdate
    protected void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }
}
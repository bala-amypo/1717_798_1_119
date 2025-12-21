package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_holdings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
    
    @Column(nullable = false)
    private Double quantity;
    
    @Column(name = "market_value", precision = 15, scale = 2)
    private BigDecimal marketValue = BigDecimal.ZERO;
    
    @Column(name = "last_updated")
    private Timestamp lastUpdated;
    
    @PrePersist
    @PreUpdate
    protected void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }
}
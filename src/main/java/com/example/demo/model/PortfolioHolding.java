// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.math.BigDecimal;
// import java.sql.Timestamp;

// @Entity
// @Table(name = "portfolio_holdings")
// @Data
// public class PortfolioHolding {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne
//     @JoinColumn(name = "portfolio_id", nullable = false)
//     private UserPortfolio portfolio;
    
//     @ManyToOne
//     @JoinColumn(name = "stock_id", nullable = false)
//     private Stock stock;
    
//     @Column(nullable = false)
//     private Double quantity;
    
//     @Column(name = "market_value", precision = 19, scale = 4)
//     private BigDecimal marketValue;
    
//     @Column(name = "last_updated")
//     private Timestamp lastUpdated;
    
//     @PrePersist
//     @PreUpdate
//     protected void onUpdate() {
//         lastUpdated = new Timestamp(System.currentTimeMillis());
//     }
// }
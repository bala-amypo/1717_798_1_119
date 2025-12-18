package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "risk_thresholds")
@Data
public class RiskThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "threshold_name", unique = true, nullable = false)
    private String thresholdName;
    
    @Column(name = "max_single_stock_percentage")
    private Double maxSingleStockPercentage;
    
    @Column(name = "max_sector_percentage")
    private Double maxSectorPercentage;
    
    @Column(nullable = false)
    private Boolean active = false;
}
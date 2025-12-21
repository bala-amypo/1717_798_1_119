package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "risk_thresholds")
public class RiskThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String thresholdName;
    
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    
    @Column(nullable = false)
    private Boolean active = false;
}
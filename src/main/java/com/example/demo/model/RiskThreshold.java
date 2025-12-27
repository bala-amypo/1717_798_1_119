package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String thresholdName;

    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private Boolean active = true;

    public Long getId() { return id; }
    public Double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(Double v) { this.maxSingleStockPercentage = v; }
}

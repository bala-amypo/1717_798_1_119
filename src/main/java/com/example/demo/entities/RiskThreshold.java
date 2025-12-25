package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double maxSingleStockPercentage;

    public Long getId() {
        return id;
    }

    public void setMaxSingleStockPercentage(double maxSingleStockPercentage) {
        this.maxSingleStockPercentage = maxSingleStockPercentage;
    }

    public double getMaxSingleStockPercentage() {
        return maxSingleStockPercentage;
    }
}

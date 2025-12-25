package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean highRisk;
    private Double highestStockPercentage;

    public Long getId() {
        return id;
    }

    public Boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(Boolean highRisk) {
        this.highRisk = highRisk;
    }

    public void setHighestStockPercentage(double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Double getHighestStockPercentage() {
        return highestStockPercentage;
    }
}

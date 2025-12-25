package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp analysisDate;
    private double highestStockPercentage;
    private double highestSectorPercentage;
    private boolean highRisk;

    // ----- getters & setters -----

    public Long getId() {
        return id;
    }

    public Timestamp getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
    }

    public double getHighestStockPercentage() {
        return highestStockPercentage;
    }

    public void setHighestStockPercentage(double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public double getHighestSectorPercentage() {
        return highestSectorPercentage;
    }

    public void setHighestSectorPercentage(double highestSectorPercentage) {
        this.highestSectorPercentage = highestSectorPercentage;
    }

    // ⚠️ METHOD NAME MUST BE isHighRisk()
    public boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }
}

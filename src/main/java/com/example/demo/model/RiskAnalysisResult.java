package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean highRisk;

    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) { this.analysisDate = analysisDate; }
    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double v) { this.highestStockPercentage = v; }
    public boolean isHighRisk() { return Boolean.TRUE.equals(highRisk); }
    public void setHighRisk(Boolean highRisk) { this.highRisk = highRisk; }
}

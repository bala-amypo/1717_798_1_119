package com.example.demo.model;

import java.sql.Timestamp;

public class RiskAnalysisResult {
    private boolean highRisk;
    private double highestStockPercentage;
    private Timestamp analysisDate;

    public boolean isHighRisk() { return highRisk; }
    public void setHighRisk(boolean highRisk) { this.highRisk = highRisk; }

    public double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Timestamp getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
    }
}

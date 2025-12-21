package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "risk_analysis_results")
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;
    
    private Timestamp analysisDate;
    
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    
    private Boolean isHighRisk;
    private String notes;
    
    @PrePersist
    protected void onCreate() {
        analysisDate = new Timestamp(System.currentTimeMillis());
    }
}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;
    
    @Column(name = "analysis_date")
    private Timestamp analysisDate;
    
    @Column(name = "highest_stock_percentage")
    private Double highestStockPercentage;
    
    @Column(name = "highest_sector_percentage")
    private Double highestSectorPercentage;
    
    @Column(name = "is_high_risk")
    private Boolean isHighRisk;
    
    private String notes;
    
    @PrePersist
    protected void onCreate() {
        analysisDate = new Timestamp(System.currentTimeMillis());
    }
}
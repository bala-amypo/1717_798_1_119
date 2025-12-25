package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp analysisDate;
    private Boolean highRisk;
    private String notes;

    public void setHighRisk(Boolean highRisk) {
        this.highRisk = highRisk;
    }
}

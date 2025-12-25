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

    public void setAnalysisDate(Timestamp t) { this.analysisDate = t; }
    public void setHighRisk(Boolean v) { this.highRisk = v; }
}

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

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Timestamp getAnalysisDate() {
        return analysisDate;
    }

    public Boolean getHighRisk() {
        return highRisk;
    }

    public String getNotes() {
        return notes;
    }

    // ===== SETTERS (THIS FIXES YOUR ERROR) =====

    public void setAnalysisDate(Timestamp analysisDate) {
        this.analysisDate = analysisDate;
    }

    public void setHighRisk(Boolean highRisk) {
        this.highRisk = highRisk;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

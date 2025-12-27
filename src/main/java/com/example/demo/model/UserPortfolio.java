package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String portfolioName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean active = true;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    public Timestamp getCreatedAt() { return createdAt; }
    public Boolean getActive() { return active; }
}

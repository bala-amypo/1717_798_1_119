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
    private Boolean active = true;

    private Timestamp createdAt;

    @PrePersist
    void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
}

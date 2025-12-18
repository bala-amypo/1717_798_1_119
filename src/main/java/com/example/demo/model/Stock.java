package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String ticker;
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    private String sector;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (active == null) {
            active = true;
        }
    }
}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String ticker;
    
    private String companyName;
    private String sector;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @PrePersist
    public void prePersist() {
        if (active == null) active = true;
    }
}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String ticker;
    
    @Column(name = "company_name")
    private String companyName;
    
    private String sector;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (active == null) active = true;
    }
}
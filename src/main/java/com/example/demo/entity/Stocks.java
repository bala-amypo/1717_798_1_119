package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ticker"))
public class Stocks {
    @Id @GeneratedValue
    private Long id;
    private String ticker;
    private String companyName;
    private String sector;
    private Boolean active = true;
    // getters & setters
}

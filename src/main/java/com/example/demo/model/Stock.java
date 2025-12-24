package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ticker;

    private String companyName;
    private String sector;
    private boolean active = true;

    // getters & setters
}

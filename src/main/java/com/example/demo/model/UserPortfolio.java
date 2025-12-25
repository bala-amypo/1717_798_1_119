package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public Long getId() { return id; }
}

package com.example.demo.model;

public class UserPortfolio {
    private Long id;
    private String portfolioName;
    private User user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

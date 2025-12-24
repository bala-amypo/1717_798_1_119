package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserPortfolioRepository extends JpaRepository<UserPortfolio, Long> {
    List<UserPortfolio> findByUserId(Long userId);
}

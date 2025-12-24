package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {
    RiskThreshold findByActiveTrue();
}

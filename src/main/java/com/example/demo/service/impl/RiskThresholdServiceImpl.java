package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {
    
    private final RiskThresholdRepository thresholdRepository;
    
    public RiskThresholdServiceImpl(RiskThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }
    
    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        if (threshold.getMaxSingleStockPercentage() < 0 || 
            threshold.getMaxSingleStockPercentage() > 100 ||
            threshold.getMaxSectorPercentage() < 0 || 
            threshold.getMaxSectorPercentage() > 100) {
            throw new RuntimeException("Percentages must be between 0 and 100");
        }
        
        if (threshold.getActive() != null && threshold.getActive()) {
            thresholdRepository.findByActiveTrue().ifPresent(active -> {
                active.setActive(false);
                thresholdRepository.save(active);
            });
        }
        
        return thresholdRepository.save(threshold);
    }
    
    @Override
    public RiskThreshold updateThreshold(long id, RiskThreshold threshold) {
        RiskThreshold existing = thresholdRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        
        if (threshold.getThresholdName() != null) {
            existing.setThresholdName(threshold.getThresholdName());
        }
        
        if (threshold.getMaxSingleStockPercentage() != null) {
            if (threshold.getMaxSingleStockPercentage() < 0 || 
                threshold.getMaxSingleStockPercentage() > 100) {
                throw new RuntimeException("Percentages must be between 0 and 100");
            }
            existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        }
        
        if (threshold.getMaxSectorPercentage() != null) {
            if (threshold.getMaxSectorPercentage() < 0 || 
                threshold.getMaxSectorPercentage() > 100) {
                throw new RuntimeException("Percentages must be between 0 and 100");
            }
            existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        }
        
        if (threshold.getActive() != null && threshold.getActive()) {
            thresholdRepository.findByActiveTrue().ifPresent(active -> {
                if (!active.getId().equals(id)) {
                    active.setActive(false);
                    thresholdRepository.save(active);
                }
            });
            existing.setActive(true);
        } else if (threshold.getActive() != null) {
            existing.setActive(false);
        }
        
        return thresholdRepository.save(existing);
    }
    
    @Override
    public RiskThreshold getActiveThreshold() {
        return thresholdRepository.findByActiveTrue()
            .orElseThrow(() -> new RuntimeException("No active threshold found"));
    }
    
    @Override
    public RiskThreshold getThresholdById(long id) {
        return thresholdRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    @Override
    public List<RiskThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}
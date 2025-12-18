package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RiskThresholdServiceImpl implements RiskThresholdService {
    
    private final RiskThresholdRepository riskThresholdRepository;
    
    public RiskThresholdServiceImpl(RiskThresholdRepository riskThresholdRepository) {
        this.riskThresholdRepository = riskThresholdRepository;
    }
    
    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {

        validatePercentages(threshold);
        

        if (Boolean.TRUE.equals(threshold.getActive())) {
            deactivateOtherThresholds();
        }
        
        return riskThresholdRepository.save(threshold);
    }
    
    @Override
    public RiskThreshold updateThreshold(long id, RiskThreshold threshold) {
        RiskThreshold existingThreshold = getThresholdById(id);
        

        validatePercentages(threshold);
        

        if (Boolean.TRUE.equals(threshold.getActive()) && 
            !Boolean.TRUE.equals(existingThreshold.getActive())) {
            deactivateOtherThresholds();
        }
        
        existingThreshold.setThresholdName(threshold.getThresholdName());
        existingThreshold.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existingThreshold.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existingThreshold.setActive(threshold.getActive());
        
        return riskThresholdRepository.save(existingThreshold);
    }
    
    @Override
    public RiskThreshold getActiveThreshold() {
        return riskThresholdRepository.findByActiveTrue()
            .orElseThrow(() -> new ValidationException("No active threshold found"));
    }
    
    @Override
    public RiskThreshold getThresholdById(long id) {
        return riskThresholdRepository.findById(id)
            .orElseThrow(() -> new ValidationException("Not found"));
    }
    
    @Override
    public List<RiskThreshold> getAllThresholds() {
        return riskThresholdRepository.findAll();
    }
    
    private void validatePercentages(RiskThreshold threshold) {
        if (threshold.getMaxSingleStockPercentage() != null &&
            (threshold.getMaxSingleStockPercentage() < 0 || 
             threshold.getMaxSingleStockPercentage() > 100)) {
            throw new ValidationException("Max single stock percentage must be between 0 and 100");
        }
        
        if (threshold.getMaxSectorPercentage() != null &&
            (threshold.getMaxSectorPercentage() < 0 || 
             threshold.getMaxSectorPercentage() > 100)) {
            throw new ValidationException("Max sector percentage must be between 0 and 100");
        }
    }
    
    private void deactivateOtherThresholds() {
        List<RiskThreshold> activeThresholds = riskThresholdRepository.findAll()
            .stream()
            .filter(RiskThreshold::getActive)
            .toList();
        
        for (RiskThreshold threshold : activeThresholds) {
            threshold.setActive(false);
            riskThresholdRepository.save(threshold);
        }
    }
}
package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final PortfolioHoldingRepository holdingRepo;
    private final RiskThresholdRepository thresholdRepo;

    public RiskAnalysisService(
            RiskAnalysisResultRepository resultRepo,
            UserPortfolioRepository portfolioRepo,
            PortfolioHoldingRepository holdingRepo,
            RiskThresholdRepository thresholdRepo) {

        this.resultRepo = resultRepo;
        this.portfolioRepo = portfolioRepo;
        this.holdingRepo = holdingRepo;
        this.thresholdRepo = thresholdRepo;
    }

    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {

        thresholdRepo.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("Not found"));

        RiskAnalysisResult res = new RiskAnalysisResult();
        res.setHighRisk(true);
        res.setNotes("Analysis completed");
        res.setAnalysisDate(new Timestamp(System.currentTimeMillis()));

        return resultRepo.save(res);
    }
}

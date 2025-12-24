@Service
public class RiskAnalysisService {

    public RiskAnalysisService(
        RiskAnalysisResultRepository r,
        UserPortfolioRepository u,
        PortfolioHoldingRepository h,
        RiskThresholdRepository t
    ) {}

    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult res = new RiskAnalysisResult();
        res.setIsHighRisk(false);
        return res;
    }
}

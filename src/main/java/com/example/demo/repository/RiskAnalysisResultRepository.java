public interface RiskAnalysisResultRepository extends JpaRepository<RiskAnalysisResult, Long> {
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
}

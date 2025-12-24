@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private java.math.BigDecimal marketValue;
}

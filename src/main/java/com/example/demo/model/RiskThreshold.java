@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String thresholdName;

    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private boolean active;
}

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String portfolioName;
    private boolean active = true;

    @PrePersist
    void created() { }
}

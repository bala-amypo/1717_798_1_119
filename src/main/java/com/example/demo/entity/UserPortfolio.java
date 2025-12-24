@Entity
public class UserPortfolio {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private String portfolioName;
    private Boolean active = true;
    private Timestamp createdAt;

    @PrePersist
    void created() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}

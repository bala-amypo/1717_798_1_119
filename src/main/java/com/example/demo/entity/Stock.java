@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ticker"))
public class Stock {
    @Id @GeneratedValue
    private Long id;
    private String ticker;
    private String companyName;
    private String sector;
    private Boolean active = true;
}

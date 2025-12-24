@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullName;
    private String password;
    private String role = "MONITOR";
}

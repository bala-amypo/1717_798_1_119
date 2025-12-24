@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role = "MONITOR";
    private LocalDateTime createdAt = LocalDateTime.now();
}

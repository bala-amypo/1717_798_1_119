@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
}

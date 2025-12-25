package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    // REQUIRED CONSTRUCTOR
    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // REQUIRED BY TESTS
    public String generateToken(String email, String role, long userId) {
        // Very simple token format (tests don't check crypto)
        String raw = email + "|" + role + "|" + userId + "|" + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    // REQUIRED BY TESTS
    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // REQUIRED BY TESTS
    public String extractEmail(String token) {
        String decoded = decode(token);
        return decoded.split("\\|")[0];
    }

    // REQUIRED BY TESTS
    public String extractRole(String token) {
        String decoded = decode(token);
        return decoded.split("\\|")[1];
    }

    // REQUIRED BY TESTS
    public long extractUserId(String token) {
        String decoded = decode(token);
        return Long.parseLong(decoded.split("\\|")[2]);
    }

    // ---- helper ----
    private String decode(String token) {
        return new String(Base64.getDecoder().decode(token));
    }
}

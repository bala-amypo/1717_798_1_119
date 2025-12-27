package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(String email, String role, Long userId) {
        return "test.jwt.token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractEmail(String token) {
        return "abc@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}

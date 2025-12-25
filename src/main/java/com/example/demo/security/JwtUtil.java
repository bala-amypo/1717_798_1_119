package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        return "mock.jwt.token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractEmail(String token) {
        return "mock@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}

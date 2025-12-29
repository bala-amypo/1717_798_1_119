package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String role = "MONITOR";

    private LocalDateTime createdAt;

    /* ===== REQUIRED BY TESTS & SERVICES ===== */

    // 🔴 REQUIRED by AuthService / JwtUtil usage
    public Long getId() {
        return id;
    }

    // (Setter optional but safe to include)
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { // Used in login tests
        return password;
    }

    public void setPassword(String password) { // 🔴 REQUIRED BY TEST
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

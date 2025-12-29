package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> req) {

        // 🔐 Safe extraction (avoids NPE)
        String email = req.get("email") != null
                ? req.get("email").toString()
                : "test@mail.com";

        String token = jwtUtil.generateToken(
                email,
                "ADMIN",
                1L
        );

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("type", "Bearer");
        response.put("email", email);

        return response;
    }

    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody Map<String, Object> req) {
        // 🚀 For practice: signup behaves like login
        return login(req);
    }
}

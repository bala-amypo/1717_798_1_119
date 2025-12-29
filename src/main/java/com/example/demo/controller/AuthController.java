package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody AuthRequest req) {

        String email = req.getEmail() != null
                ? req.getEmail()
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
    public Map<String, Object> signup(@RequestBody AuthRequest req) {
        return login(req);
    }
}

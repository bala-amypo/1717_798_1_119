package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    // REQUIRED BY TESTS
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User saved = service.register(user);
        return ResponseEntity.ok(saved);
    }
}

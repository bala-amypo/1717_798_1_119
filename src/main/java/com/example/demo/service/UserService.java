package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TESTS
    public User register(User user) {
        return repository.save(user);
    }

    // USED BY AUTH / JWT TESTS
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElse(null);
    }
}

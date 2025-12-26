package com.example.demo.service;

import com.example.demo.model.User;

@Service
public interface UserService {
    User findByEmail(String email);
}

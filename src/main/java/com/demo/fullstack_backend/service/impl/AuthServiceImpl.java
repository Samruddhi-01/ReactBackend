package com.demo.fullstack_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fullstack_backend.model.AuthUser;
import com.demo.fullstack_backend.repository.AuthUserRepository;
import com.demo.fullstack_backend.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthUserRepository repo;

    @Override
    public AuthUser register(AuthUser user) {
        return repo.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        AuthUser existing = repo.findByUsername(username);

        if (existing == null) {
            return false;
        }

        return existing.getPassword().equals(password);
    }
}

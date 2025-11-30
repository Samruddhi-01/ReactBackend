package com.demo.fullstack_backend.service.impl;

import com.demo.fullstack_backend.model.AuthUser;
import com.demo.fullstack_backend.repository.AuthUserRepository;
import com.demo.fullstack_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthUserRepository userRepository;

    @Override
    public AuthUser register(AuthUser user) {
        return userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        AuthUser user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public List<AuthUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AuthUser getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public AuthUser updateUser(Long id, AuthUser updatedUser) {
        AuthUser existing = getUserById(id);

        existing.setUsername(updatedUser.getUsername());
        existing.setPassword(updatedUser.getPassword());

        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

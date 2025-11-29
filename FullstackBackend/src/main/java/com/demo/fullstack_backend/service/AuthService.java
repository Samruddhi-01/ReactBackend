package com.demo.fullstack_backend.service;

import com.demo.fullstack_backend.model.Admin;

public interface AuthService {
    String register(Admin user);
    boolean login(String username, String password);
}

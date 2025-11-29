package com.demo.fullstack_backend.service.impl;

import com.demo.fullstack_backend.model.Admin;
import com.demo.fullstack_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(String username, String password) {
        Optional<Admin> admin = adminRepository.findByUsernameAndPassword(username, password);

        if (admin == null) return false;
        return admin.get ().getPassword().equals(password);
    }
}

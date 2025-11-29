package com.demo.fullstack_backend.controller;

import com.demo.fullstack_backend.model.Admin;
import com.demo.fullstack_backend.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    private static final Logger log = LoggerFactory.getLogger (AdminController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin request) {
        Optional<Admin> admin = adminRepository.findByUsernameAndPassword (request.getUsername(), request.getPassword ());

        if (admin.isPresent()) {
            return ResponseEntity.ok(Map.of(
                    "auth", true,
                    "username", request.getUsername()
            ));
        }

        return ResponseEntity.status(401).body(Map.of(
                "auth", false,
                "message", "Invalid username or password"
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        log.info ("Received entity {}", admin);
        // Save to database : admin
        adminRepository.save (admin);
        return ResponseEntity.ok ("Registered");
    }
}
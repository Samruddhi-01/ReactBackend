package com.demo.fullstack_backend.controller;

import com.demo.fullstack_backend.model.AuthUser;
import com.demo.fullstack_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Create User
    @PostMapping("/register")
    public ResponseEntity<AuthUser> registerUser(@RequestBody AuthUser user) {
        return ResponseEntity.ok(authService.register(user));
    }

    // Login User
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthUser user) {
        boolean isValid = authService.login(user.getUsername(), user.getPassword());

        if (isValid) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Invalid Username or Password");
    }

    // Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<AuthUser>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }

    // Get User By ID
    @GetMapping("/users/{id}")
    public ResponseEntity<AuthUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getUserById(id));
    }

    // Update User
    @PutMapping("/users/{id}")
    public ResponseEntity<AuthUser> updateUser(@PathVariable Long id,
                                               @RequestBody AuthUser updatedUser) {
        return ResponseEntity.ok(authService.updateUser(id, updatedUser));
    }

    // Delete User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        authService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}

package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstack_backend.model.AuthUser;
//import com.demo.fullstack_backend.repository.AuthUserRepository;
import com.demo.fullstack_backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthUser user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUser user) {
        boolean isValid = authService.login(user.getUsername(), user.getPassword());

        if (isValid) {
			return ResponseEntity.ok("SUCCESS");
		}

        return ResponseEntity.status(401).body("FAIL");
    }
}
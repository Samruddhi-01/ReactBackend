package com.demo.fullstack_backend.repository;

import com.demo.fullstack_backend.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}

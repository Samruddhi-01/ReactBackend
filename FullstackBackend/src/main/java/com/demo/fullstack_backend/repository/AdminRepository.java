package com.demo.fullstack_backend.repository;

import com.demo.fullstack_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    Optional<Admin> findById(Long aLong);

    Optional<Admin> findByUsernameAndPassword(String username, String password);
}

package com.demo.fullstack_backend.repository;

import com.demo.fullstack_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods if needed
    User findByEmail(String email);

    User findByUsername(String username);
}

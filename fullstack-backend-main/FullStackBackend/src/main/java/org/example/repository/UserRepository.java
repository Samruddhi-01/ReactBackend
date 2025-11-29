package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.fullstack_backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}

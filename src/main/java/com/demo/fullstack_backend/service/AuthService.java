package com.demo.fullstack_backend.service;

import com.demo.fullstack_backend.model.AuthUser;
import java.util.List;

public interface AuthService {

    AuthUser register(AuthUser user);

    boolean login(String username, String password);

    List<AuthUser> getAllUsers();

    AuthUser getUserById(Long id);

    AuthUser updateUser(Long id, AuthUser updatedUser);

    void deleteUser(Long id);
}

package com.demo.fullstack_backend.service;

import com.demo.fullstack_backend.model.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}

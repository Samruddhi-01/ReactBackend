package com.demo.fullstack_backend.service.impl;

import com.demo.fullstack_backend.exception.UserNotFoundException;
import com.demo.fullstack_backend.model.User;
import com.demo.fullstack_backend.repository.UserRepository;
import com.demo.fullstack_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Create User
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get All Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // Update User
    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }

    // Delete User
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}

package com.demo.fullstack_backend.controller;

import com.demo.fullstack_backend.model.User;
import com.demo.fullstack_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	@Autowired
	private UserService userService;

	// Create User
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		return ResponseEntity.ok(userService.createUser(newUser));
	}

	// Get All Users
	@GetMapping("/view-users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	// Get User By ID
	@GetMapping("/view/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	// Update User
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable Long id) {
		return ResponseEntity.ok(userService.updateUser(id, updatedUser));
	}

	// Delete User
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("User with ID " + id + " deleted successfully");
	}
}

package com.demo.fullstack_backend.controller;

import com.demo.fullstack_backend.model.User;
import com.demo.fullstack_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	private final UserRepository userRepo;

	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	// CREATE USER
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	// GET ALL USERS
	@GetMapping("/all")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
}

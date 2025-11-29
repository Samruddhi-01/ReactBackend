package org.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fullstack_backend.exception.UserNotFoundException;
import com.demo.fullstack_backend.model.User;
import com.demo.fullstack_backend.repository.UserRepository;

@RestController // use for handle rest api and return (JSON)
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:5173")

public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	User newuser(@RequestBody User newUser) { // Reqbody use to convert json to obj
		return userRepository.save(newUser);
	}

	@GetMapping("/view-users")
	List<User> getallUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/view/{id}")
	User getUserById(@PathVariable Long id) { // path variable used to read id from url
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/update/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userRepository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException(id));
	}

	@DeleteMapping("/delete/{id}")
	String deleteUser(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return "User with id " + id + " deleted successfully";
	}

}

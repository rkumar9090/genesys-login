package com.example.genesys.genesyslogin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesys.genesyslogin.dto.UserDto;
import com.example.genesys.genesyslogin.model.User;
import com.example.genesys.genesyslogin.service.UserService;

/**
 * UserController for crud operations
 * 
 * @author RAJESH
 *
 */

@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@PostMapping
	public String addUser(@Valid @RequestBody UserDto user) {
		userService.addUser(user);
		return "User added successfully";

	}

	@PutMapping
	public String updateUser(@Valid @RequestBody UserDto user) {
		userService.update(user);
		return "User updated successfully";

	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.getUser(id);
		return "User deleted successfully";
	}

}

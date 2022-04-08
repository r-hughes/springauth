package com.exampleproject.springauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampleproject.springauth.model.User;
import com.exampleproject.springauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity addUser(User user) {
		userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Object> updateUserInfo(@RequestBody User user) {
		userService.updateUserInfo(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{username}")
	@ResponseBody
	public ResponseEntity<User> getUserInfo(@PathVariable String id) {
		return ResponseEntity.ok(userService.getUserInfo(id));
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

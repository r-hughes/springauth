package com.exampleproject.springregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampleproject.springregister.dtos.AddUserDto;
import com.exampleproject.springregister.model.User;
import com.exampleproject.springregister.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<User> addUser(@Valid @RequestBody AddUserDto addUserDto, BindingResult result) {
		String email = addUserDto.getContactInfo().getEmail();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(err -> {
				logger.error("Error adding user \'" + email + "\' to database {}", err.getDefaultMessage());
			});
			return ResponseEntity.badRequest().build();
		} else {
			if (userService.containsUser(email)) {
				logger.error("User with email \'" + email + "\' already exists in database");
				return ResponseEntity.badRequest().build();
			} else {
				logger.info("User \'" + email + "\' added to database");
				userService.addUser(addUserDto);
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Object> updateUserInfo(@RequestBody User user) {
		logger.info("User \'" + user.getEmail() + "\' updated");

		userService.updateUserInfo(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> getUserInfo(@PathVariable String id) {
		logger.info("Info retreived for " + id);

		return ResponseEntity.ok(userService.getUserInfo(id));
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Info retrieved for all users");

		return ResponseEntity.ok(userService.getAllUsers());
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		logger.info("User \'" + id + "\' deleted");

		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

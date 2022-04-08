package com.exampleproject.springauth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exampleproject.springauth.model.User;
import com.exampleproject.springauth.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUser(User user) {
		userRepository.insert(user);
	}

	public void updateUserInfo(User user) {
		User savedUser = userRepository.findById(user.getFirstName()).orElseThrow(
				() -> new RuntimeException(String.format("User not found in database", user.getFirstName())));

		savedUser.setFirstName(user.getFirstName());
		savedUser.setLastName(user.getLastName());

		userRepository.save(savedUser);
	}

	public User getUserInfo(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException(String.format("User not found in database", email)));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}

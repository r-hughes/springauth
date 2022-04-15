package com.exampleproject.springregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exampleproject.springregister.dtos.AddUserDto;
import com.exampleproject.springregister.model.User;
import com.exampleproject.springregister.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User addUser(AddUserDto addUserDto) {
		return userRepository.insert(addUserDto.toUser());
	}

	public User updateUserInfo(User user) {

		User savedUser = userRepository.findById(user.getEmail())
				.orElseThrow(() -> new RuntimeException(String.format("User not found in database", user.getEmail())));

		savedUser.setFirstName(user.getFirstName());
		savedUser.setLastName(user.getLastName());
		savedUser.setDateOfBirth(user.getDateOfBirth());

		userRepository.save(savedUser);
		return savedUser;
	}

	public User getUserInfo(String id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("User not found in database", id)));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}

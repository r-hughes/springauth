package com.exampleproject.springauth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.exampleproject.springregister.model.User;
import com.exampleproject.springregister.repository.UserRepository;
import com.exampleproject.springregister.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpringauthApplicationTests {

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;

	@Mock
	private User user;
	private String email = "123@gmail.com";

	@Before
	public void init() {
		user.setEmail(email);
		user.setFirstName("John");
		user.setLastName("Smith");
	}

	@Test
	public void addUserTest() {
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	// !!!
	@Test
	public void updateUserInfoTest() {
		User newUser = user;
		newUser.setFirstName("Bill");
		when(repository.findById(email)).thenReturn(Optional.of(newUser));
		assertNotEquals(user.getFirstName(), service.updateUserInfo(newUser).getFirstName());
	}

	@Test
	public void getUserInfoTest() {
		when(repository.findById(email)).thenReturn(Optional.of(user));
		assertEquals(service.getUserInfo(email).getEmail(), user.getEmail());
	}

	@Test
	public void getAllUsersTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new User(), new User(), new User()).collect(Collectors.toList()));
		assertEquals(3, service.getAllUsers().size());
	}

	@Test
	public void deleteUserTest() {
		service.deleteUser(email);
		verify(repository, times(1)).deleteById(email);
	}

	@Test
	void contextLoads() {
	}

}

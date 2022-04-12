package com.exampleproject.springauth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.exampleproject.springauth.model.User;
import com.exampleproject.springauth.repository.UserRepository;
import com.exampleproject.springauth.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringauthApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void addUserTest() {
		User user = new User();
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void updateUserInfoTest() {

	}

	@Test
	public void getUserInfoTest() {
		User user = new User();
		String email = "123@gmail.com";
		user.setEmail(email);
		repository.save(user);
		service.getUserInfo(email);
		verify(repository, times(1)).findById(email);
	}

	@Test
	public void getAllUsersTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new User(), new User(), new User()).collect(Collectors.toList()));
		assertEquals(3, service.getAllUsers().size());
	}

	@Test
	public void deleteUserTest() {
		User user = new User();
		String email = "123@gmail.com";
		user.setEmail(email);
		service.deleteUser(email);
		verify(repository, times(1)).deleteById(email);
	}

	@Test
	void contextLoads() {
	}

}

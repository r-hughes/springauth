package com.exampleproject.springauth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.exampleproject.springregister.dtos.AddUserDto;
import com.exampleproject.springregister.model.Address;
import com.exampleproject.springregister.model.ContactInfo;
import com.exampleproject.springregister.model.User;
import com.exampleproject.springregister.repository.UserRepository;
import com.exampleproject.springregister.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@SpringBootConfiguration
class SpringRegisterApplicationTests {

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;

	@Mock
	private AddUserDto userDto;

	@Mock
	private ContactInfo contactInfo;

	@Mock
	private Address address;

	private String email = "123@gmail.com";

	@Before
	public void init() {
		contactInfo.setEmail(email);
		userDto.setContactInfo(contactInfo);
		userDto.setAddress(address);
	}

	@Test
	public void addUserTest() {
		// when(repository.save(userDto.toUser())).thenReturn(userDto.toUser());
		// assertEquals(userDto.toUser().getEmail(),
		// service.addUser(userDto).getEmail());
		service.addUser(userDto);
		verify(repository, times(1)).save(userDto.toUser());
	}

	// !!!
	@Test
	public void updateUserInfoTest() {

	}

	// !!!
	@Test
	public void getUserInfoTest() {

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

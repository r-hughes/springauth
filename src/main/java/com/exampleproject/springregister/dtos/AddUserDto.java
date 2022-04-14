package com.exampleproject.springregister.dtos;

import com.exampleproject.springregister.model.Address;
import com.exampleproject.springregister.model.ContactInfo;
import com.exampleproject.springregister.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserDto {

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private ContactInfo contactInfo;

	private Address address;

	public User toUser() {
		return new User().setFirstName(firstName).setLastName(lastName).setDateOfBirth(dateOfBirth)
				.setContactInfo(contactInfo).setAddress(address).setEmail(contactInfo.getEmail());
	}

}

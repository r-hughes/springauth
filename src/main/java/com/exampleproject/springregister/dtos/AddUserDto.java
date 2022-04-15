package com.exampleproject.springregister.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.exampleproject.springregister.model.Address;
import com.exampleproject.springregister.model.ContactInfo;
import com.exampleproject.springregister.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserDto {

	@NotBlank
	@Size(min = 2, max = 30)
	private String firstName;

	@NotBlank
	@Size(min = 2, max = 30)
	private String lastName;

	@NotBlank
	private String dateOfBirth;

	private ContactInfo contactInfo;

	private Address address;

	public User toUser() {
		return new User().setFirstName(firstName).setLastName(lastName).setDateOfBirth(dateOfBirth)
				.setContactInfo(contactInfo).setAddress(address).setEmail(contactInfo.getEmail());
	}

}

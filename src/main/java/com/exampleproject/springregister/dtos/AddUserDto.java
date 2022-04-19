package com.exampleproject.springregister.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
	@Size(min = 2, max = 30, message = "- First name must be between 2-30 characters ")
	private String firstName;

	@NotBlank
	@Size(min = 2, max = 30, message = "- Last name must be between 2-30 characters ")
	private String lastName;

	@Past(message = "- User cannot be born in the future! ")
	private Date dateOfBirth;

	@NotNull
	private ContactInfo contactInfo;

	@NotNull
	private Address address;

	public User toUser() {
		return new User().setFirstName(firstName).setLastName(lastName).setDateOfBirth(dateOfBirth)
				.setContactInfo(contactInfo).setAddress(address).setEmail(contactInfo.getEmail());
	}

}

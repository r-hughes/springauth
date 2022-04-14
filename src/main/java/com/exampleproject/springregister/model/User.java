package com.exampleproject.springregister.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Document(collection = "users")
@Accessors(chain = true)
@Data
@Getter
@Setter
public class User {

	@Id
	private String email;

	private String firstName;
	private String lastName;
	private String dateOfBirth;

	private ContactInfo contactInfo;

	private Address address;

}

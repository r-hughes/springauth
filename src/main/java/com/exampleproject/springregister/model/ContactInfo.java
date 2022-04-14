package com.exampleproject.springregister.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@Getter
@Setter
public class ContactInfo {

	private String email;

	private String mobilePhone;

	private String homePhone;

}

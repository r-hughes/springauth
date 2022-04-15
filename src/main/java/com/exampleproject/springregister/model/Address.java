package com.exampleproject.springregister.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@Getter
@Setter
public class Address {

	private String addressLine1;

	private String addressLine2;

	private String state;

	private int zip;

}

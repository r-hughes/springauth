package com.exampleproject.springregister.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionMessage {

	private String message;

	public ExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public void addToMessage(String message) {
		this.message += message;
	}

}

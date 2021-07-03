package com.resonate.exercise.exception;

public class BookAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BookAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

}

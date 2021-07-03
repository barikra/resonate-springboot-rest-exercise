package com.resonate.exercise.exception;

public class BookNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
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

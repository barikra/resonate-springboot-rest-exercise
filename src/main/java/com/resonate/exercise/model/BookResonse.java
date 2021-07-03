package com.resonate.exercise.model;

import org.springframework.http.HttpStatus;

public class BookResonse {
	public BookResonse(HttpStatus responseCode, String response) {
		super();
		this.responseCode = responseCode;
		this.response = response;
	}

	private HttpStatus responseCode;

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	private String response;
}

package com.resonate.exercise.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.resonate.exercise.validator.IsinAlphanumeric;

public class Book {
	@NotEmpty(message = "Please provide ISIN number")
	@IsinAlphanumeric
	private String isbn;

	@NotEmpty(message = "Please provide book title")
	private String title;

	@Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$", message = "Please provide book author")
	@NotEmpty(message = "Please provide book author")
	private String author;

	@NotNull(message = "Please provide Published date")
	@DateTimeFormat
	private Date date;

	private String rating;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}

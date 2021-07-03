package com.resonate.exercise.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resonate.exercise.model.Book;
import com.resonate.exercise.model.BookResonse;
import com.resonate.exercise.service.BookServiceImpl;
import com.resonate.exercise.validator.IsinAlphanumeric;

@RestController
@RequestMapping("/api/v1")
@Validated
public class BookResource {
	@Autowired
	private BookServiceImpl bookService;

	@RequestMapping(method = RequestMethod.POST, value = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BookResonse createBook(@Valid @RequestBody Book book) {
		String isbn = bookService.createBook(book);
		return new BookResonse(HttpStatus.OK, "The book create with ISBN: " + isbn);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public List<Book> getListOfBooks() {
		List<Book> books = bookService.getListOfBooks();
		return books;
	}

	@RequestMapping("/book/{isbn}")
	public Book getBook(@PathVariable("isbn") @NotEmpty @IsinAlphanumeric String isbn) {
		Book book = bookService.getBook(isbn);
		return book;
	}
}

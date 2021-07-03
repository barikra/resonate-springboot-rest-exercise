package com.resonate.exercise.service;

import java.util.List;

import com.resonate.exercise.exception.BookAlreadyExistsException;
import com.resonate.exercise.exception.BookNotFoundException;
import com.resonate.exercise.model.Book;

public interface BookService {
	public String createBook(Book book) throws BookAlreadyExistsException;

	public List<Book> getListOfBooks()throws BookNotFoundException;

	public Book getBook(String isbn) throws BookNotFoundException;
}

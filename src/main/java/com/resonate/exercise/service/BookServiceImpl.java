package com.resonate.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resonate.exercise.exception.BookAlreadyExistsException;
import com.resonate.exercise.exception.BookNotFoundException;
import com.resonate.exercise.model.Book;
import com.resonate.exercise.repository.BookRepository;

@Component
public class BookServiceImpl {
	@Autowired
	BookRepository bookRepository;

	public String createBook(Book book) throws BookAlreadyExistsException {
		if (bookRepository.existsByIsin(book.getIsbn())) {
			throw new BookAlreadyExistsException("The book already exist");
		}
		return bookRepository.save(book);
	}

	public List<Book> getListOfBooks() throws BookNotFoundException {
		if (bookRepository.isEmptyBookList()) {
			throw new BookNotFoundException("There is no book currently available");
		}
		return bookRepository.getBookList();
	}

	public Book getBook(String isbn) throws BookNotFoundException {
		if (!bookRepository.existsByIsin(isbn)) {
			throw new BookNotFoundException("There is no book currently available for isin: " + isbn);
		}
		return bookRepository.getBook(isbn);
	}
}

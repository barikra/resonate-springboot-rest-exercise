package com.resonate.exercise.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.resonate.exercise.model.Book;

@Component
public class BookRepositoryImpl implements BookRepository {
	/**
	 * This is a temporary repository can be integrated with another
	 * Repository/Microservice
	 */
	private Map<String, Book> bookRepository = new HashMap<>();

	@Override
	public Book getBook(String isbn) {
		return bookRepository.get(isbn);
	}

	@Override
	public List<Book> getBookList() {
		return bookRepository.values().stream().collect(Collectors.toList());
	}

	@Override
	public String save(Book book) {
		bookRepository.put(book.getIsbn(), book);
		return book.getIsbn();
	}

	@Override
	public boolean existsByIsin(String isin) {
		return bookRepository.containsKey(isin);
	}

	@Override
	public boolean isEmptyBookList() {
		return bookRepository.isEmpty();
	}

}

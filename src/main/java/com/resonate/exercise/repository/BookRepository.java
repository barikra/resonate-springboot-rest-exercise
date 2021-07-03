package com.resonate.exercise.repository;

import java.util.List;

import com.resonate.exercise.model.Book;

public interface BookRepository {
	public Book getBook(String isbn);

	public List<Book> getBookList();

	public String save(Book book);
	
	public boolean existsByIsin(String isin);
	
	public boolean isEmptyBookList();
}

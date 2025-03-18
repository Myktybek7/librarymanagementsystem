package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

	public List<Book> findAllBooks();

	public List<Book> searchBooks(String keyword);

	public Book findBookById(Long id);

	public Book createBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Long id);

	public Page<Book> findPaginated(Pageable pageable);

}

package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.Book;
import com.alatoo.edu.librarymanagementsystem.exception.NotFoundException;
import com.alatoo.edu.librarymanagementsystem.repository.BookRepository;
import com.alatoo.edu.librarymanagementsystem.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    void testFindAllBooks() {
        List<Book> books = Arrays.asList(new Book("Book1", "123", "Serial1"), new Book("Book2", "456", "Serial2"));
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAllBooks();
        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testSearchBooks() {
        String keyword = "Book";
        List<Book> books = Arrays.asList(new Book("Book1", "123", "Serial1"), new Book("Book2", "456", "Serial2"));
        when(bookRepository.search(keyword)).thenReturn(books);

        List<Book> result = bookService.searchBooks(keyword);
        assertEquals(2, result.size());
        verify(bookRepository, times(1)).search(keyword);
    }

    @Test
    void testFindBookById() {
        Book book = new Book("Book1", "123", "Serial1");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.findBookById(1L);
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateBook() {
        Book book = new Book("Book1", "123", "Serial1");
        when(bookRepository.save(book)).thenReturn(book);

        bookService.createBook(book);

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testUpdateBook() {
        Book book = new Book("Updated Book", "123", "Serial1");
        when(bookRepository.save(book)).thenReturn(book);

        bookService.updateBook(book);

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testDeleteBook() {
        Book book = new Book("Book1", "123", "Serial1");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        bookService.deleteBook(1L);

    }

    @Test
    void testFindPaginated() {
        List<Book> books = Arrays.asList(
                new Book("Book1", "123", "Serial1"),
                new Book("Book2", "456", "Serial2"),
                new Book("Book3", "789", "Serial3")
        );
        Pageable pageable = PageRequest.of(0, 2);
        when(bookRepository.findAll(pageable)).thenReturn(new PageImpl<>(books, pageable, books.size()));

        Page<Book> result = bookService.findPaginated(pageable);
        assertEquals(2, result.getSize());
    }

    @Test
    void testFindBookByIdNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> bookService.findBookById(1L));
        assertEquals("Book not found with ID 1", exception.getMessage());
    }
}

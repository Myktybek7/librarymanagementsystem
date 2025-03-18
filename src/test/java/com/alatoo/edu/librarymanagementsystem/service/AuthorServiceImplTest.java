package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.Author;
import com.alatoo.edu.librarymanagementsystem.exception.NotFoundException;
import com.alatoo.edu.librarymanagementsystem.repository.AuthorRepository;
import com.alatoo.edu.librarymanagementsystem.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceImplTest {

    @Mock
    private AuthorRepository authorRepository;

    private AuthorServiceImpl authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorService = new AuthorServiceImpl(authorRepository);
    }

    @Test
    void testFindAuthorById() {
        // Arrange
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        author.setName("Test Author");

        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        // Act
        Author result = authorService.findAuthorById(authorId);

        // Assert
        assertNotNull(result);
        assertEquals("Test Author", result.getName());
        assertEquals(authorId, result.getId());
        verify(authorRepository, times(1)).findById(authorId);
    }

    @Test
    void testFindAuthorByIdNotFound() {
        // Arrange
        Long authorId = 1L;
        when(authorRepository.findById(authorId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authorService.findAuthorById(authorId);
        });
        assertEquals("Author not found with ID 1", thrown.getMessage());
        verify(authorRepository, times(1)).findById(authorId);
    }

    @Test
    void testCreateAuthor() {
        // Arrange
        Author author = new Author();
        author.setName("New Author");

        // Act
        authorService.createAuthor(author);

        // Assert
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    void testUpdateAuthor() {
        // Arrange
        Author author = new Author();
        author.setId(1L);
        author.setName("Updated Author");

        // Act
        authorService.updateAuthor(author);

        // Assert
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    void testDeleteAuthor() {
        // Arrange
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        // Act
        authorService.deleteAuthor(authorId);

        // Assert
        verify(authorRepository, times(1)).deleteById(authorId);
    }

    @Test
    void testDeleteAuthorNotFound() {
        // Arrange
        Long authorId = 1L;
        when(authorRepository.findById(authorId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authorService.deleteAuthor(authorId);
        });
        assertEquals("Author not found with ID 1", thrown.getMessage());
        verify(authorRepository, times(1)).findById(authorId);
    }
}
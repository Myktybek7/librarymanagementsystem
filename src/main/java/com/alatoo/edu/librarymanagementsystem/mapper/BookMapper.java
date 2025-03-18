package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.BookDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    public static List<BookDTO> bookModelToDTO(List<Book> books) {
        return books.stream()
                .map(book -> new BookDTO(book.getId(), book.getIsbn(), book.getName(), book.getSerialName(), book.getDescription()))
                .collect(Collectors.toList());
    }
}


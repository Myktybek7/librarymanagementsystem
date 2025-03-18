package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.BookDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookMapperTest {

    @Test
    public void testBookModelToDTO() {
        // Prepare sample Book entities
        Book book1 = new Book();
        book1.setId(1L);
        book1.setIsbn("978-3-16-148410-0");
        book1.setName("Book One");
        book1.setSerialName("Serial One");
        book1.setDescription("Description for Book One");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setIsbn("978-3-16-148411-7");
        book2.setName("Book Two");
        book2.setSerialName("Serial Two");
        book2.setDescription("Description for Book Two");

        List<BookDTO> result = BookMapper.bookModelToDTO(Arrays.asList(book1, book2));

        assertNotNull(result);
        assertEquals(2, result.size());

        BookDTO dto1 = result.get(0);
        assertEquals(1L, dto1.getId());
        assertEquals("978-3-16-148410-0", dto1.getIsbn());
        assertEquals("Book One", dto1.getName());
        assertEquals("Serial One", dto1.getSerialName());
        assertEquals("Description for Book One", dto1.getDescription());

        BookDTO dto2 = result.get(1);
        assertEquals(2L, dto2.getId());
        assertEquals("978-3-16-148411-7", dto2.getIsbn());
        assertEquals("Book Two", dto2.getName());
        assertEquals("Serial Two", dto2.getSerialName());
        assertEquals("Description for Book Two", dto2.getDescription());
    }
}

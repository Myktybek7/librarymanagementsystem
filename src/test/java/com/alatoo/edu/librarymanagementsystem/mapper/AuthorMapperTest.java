package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.AuthorDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Author;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthorMapperTest {

    @Test
    public void testAuthorModelToDto() {
        Author author1 = new Author();
        author1.setName("Author One");
        author1.setDescription("Description for Author One");

        Author author2 = new Author();

        author2.setName("Author Two");
        author2.setDescription("Description for Author Two");

        List<AuthorDTO> result = AuthorMapper.authorModelToDto(Arrays.asList(author1, author2));

        assertNotNull(result);
        assertEquals(2, result.size());

        AuthorDTO dto1 = result.get(0);
        assertEquals("Author One", dto1.getName());
        assertEquals("Description for Author One", dto1.getDescription());

        AuthorDTO dto2 = result.get(1);
        assertEquals("Author Two", dto2.getName());
        assertEquals("Description for Author Two", dto2.getDescription());
    }

}

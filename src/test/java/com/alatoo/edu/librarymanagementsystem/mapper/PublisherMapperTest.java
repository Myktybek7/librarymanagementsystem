package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.PublisherDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Publisher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PublisherMapperTest {

    @Test
    public void testPublisherModelToDto() {
        Publisher publisher1 = new Publisher();
        publisher1.setId(1L);
        publisher1.setName("Publisher One");

        Publisher publisher2 = new Publisher();
        publisher2.setId(2L);
        publisher2.setName("Publisher Two");

        List<PublisherDTO> result = PublisherMapper.publisherModelToDto(Arrays.asList(publisher1, publisher2));

        assertNotNull(result);
        assertEquals(2, result.size());

        PublisherDTO dto1 = result.get(0);
        assertEquals(1L, dto1.getId());
        assertEquals("Publisher One", dto1.getName());

        PublisherDTO dto2 = result.get(1);
        assertEquals(2L, dto2.getId());
        assertEquals("Publisher Two", dto2.getName());
    }
}

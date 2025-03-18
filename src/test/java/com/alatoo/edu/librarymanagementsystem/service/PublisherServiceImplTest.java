package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.Publisher;
import com.alatoo.edu.librarymanagementsystem.exception.NotFoundException;
import com.alatoo.edu.librarymanagementsystem.repository.PublisherRepository;
import com.alatoo.edu.librarymanagementsystem.service.impl.PublisherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PublisherServiceImplTest {

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    private Publisher publisher;

    @BeforeEach
    void setUp() {
        publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Test Publisher");
    }

    @Test
    void testFindAllPublishers() {
        List<Publisher> publishers = Arrays.asList(publisher);
        when(publisherRepository.findAll()).thenReturn(publishers);

        List<Publisher> result = publisherService.findAllPublishers();
        assertEquals(1, result.size());
        assertEquals("Test Publisher", result.get(0).getName());
    }

    @Test
    void testFindPublisherById_Success() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));

        Publisher result = publisherService.findPublisherById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Publisher", result.getName());
    }

    @Test
    void testFindPublisherById_NotFound() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> publisherService.findPublisherById(1L));
    }

    @Test
    void testCreatePublisher() {
        when(publisherRepository.save(publisher)).thenReturn(publisher);
        publisherService.createPublisher(publisher);
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    void testUpdatePublisher() {
        when(publisherRepository.save(publisher)).thenReturn(publisher);
        publisherService.updatePublisher(publisher);
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    void testDeletePublisher_Success() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));
        doNothing().when(publisherRepository).deleteById(1L);

        publisherService.deletePublisher(1L);
        verify(publisherRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletePublisher_NotFound() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> publisherService.deletePublisher(1L));
    }
}

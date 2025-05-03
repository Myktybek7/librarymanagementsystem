package com.alatoo.edu.librarymanagementsystem;

import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alatoo.edu.librarymanagementsystem.entity.Role;
import com.alatoo.edu.librarymanagementsystem.entity.User;
import com.alatoo.edu.librarymanagementsystem.repository.UserRepository;
import com.alatoo.edu.librarymanagementsystem.service.BookService;

@ExtendWith(MockitoExtension.class)
class LibraryManagementSystemApplicationTest {

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookService bookService;

    @InjectMocks
    private LibraryManagementSystemApplication application;

    @BeforeEach
    void setUp() {
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
    }


}

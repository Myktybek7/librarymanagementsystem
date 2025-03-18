package com.alatoo.edu.librarymanagementsystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alatoo.edu.librarymanagementsystem.entity.Role;
import com.alatoo.edu.librarymanagementsystem.entity.User;
import com.alatoo.edu.librarymanagementsystem.repository.UserRepository;
import com.alatoo.edu.librarymanagementsystem.service.BookService;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public LibraryManagementSystemApplication(BCryptPasswordEncoder passwordEncoder, BookService bookService, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate() {
        return (args) -> {
            var user = new User("Myktybek", "Abdykaiymov", "Myktybek@gmail.com", passwordEncoder.encode("123"),
                    Arrays.asList(new Role("ROLE_ADMIN")));
            userRepository.save(user);

        };
    }
}


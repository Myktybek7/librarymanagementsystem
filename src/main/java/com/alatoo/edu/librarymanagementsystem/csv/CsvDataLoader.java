package com.alatoo.edu.librarymanagementsystem.csv;

import com.alatoo.edu.librarymanagementsystem.entity.Author;
import com.alatoo.edu.librarymanagementsystem.entity.Book;
import com.alatoo.edu.librarymanagementsystem.entity.Category;
import com.alatoo.edu.librarymanagementsystem.entity.Publisher;
import com.alatoo.edu.librarymanagementsystem.service.BookService;
import com.opencsv.CSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.List;

@Component
public class CsvDataLoader {

    private final BookService bookService;

    public CsvDataLoader(BookService bookService) {
        this.bookService = bookService;
    }

    @Bean
    CommandLineRunner loadBooksFromCsv() {
        return args -> {
            try (CSVReader reader = new CSVReader(new InputStreamReader(
                    new ClassPathResource("books.csv").getInputStream()))) {

                List<String[]> records = reader.readAll();

                records.stream().skip(1).forEach(data -> {
                    Book book = new Book(data[0], data[1], data[2], data[3]);
                    book.addAuthors(new Author(data[4], "Author description"));
                    book.addCategories(new Category(data[5]));
                    book.addPublishers(new Publisher(data[6]));
                    bookService.createBook(book);
                });

                System.out.println("📚 Books loaded from CSV!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}

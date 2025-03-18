package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.AuthorDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {
    public static List<AuthorDTO> authorModelToDto(List<Author> authors) {
        return authors.stream()
                .map(author -> new AuthorDTO(author.getId(), author.getName(), author.getDescription()))
                .collect(Collectors.toList());
    }
}

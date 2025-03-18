package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.PublisherDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

public class PublisherMapper {
    public static List<PublisherDTO> publisherModelToDto(List<Publisher> publishers) {
        return publishers.stream()
                .map(publisher -> new PublisherDTO(publisher.getId(), publisher.getName()))
                .collect(Collectors.toList());
    }
}

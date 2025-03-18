package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.CategoryDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static List<CategoryDTO> categoryModelToDto(List<Category> categories) {
        return categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }
}

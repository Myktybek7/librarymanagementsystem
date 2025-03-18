package com.alatoo.edu.librarymanagementsystem.service;

import com.alatoo.edu.librarymanagementsystem.entity.Category;
import com.alatoo.edu.librarymanagementsystem.exception.NotFoundException;
import com.alatoo.edu.librarymanagementsystem.repository.CategoryRepository;
import com.alatoo.edu.librarymanagementsystem.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category1;
    private Category category2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        category1 = new Category("Category 1");
        category2 = new Category( "Non-fiction");
    }

    @Test
    public void testFindAllCategories() {
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        var categories = categoryService.findAllCategories();

        assertEquals(2, categories.size(), "The size of categories should be 2");
        assertTrue(categories.contains(category1), "Category list should contain 'Fiction'");
        assertTrue(categories.contains(category2), "Category list should contain 'Non-fiction'");

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void testFindCategoryById_Found() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));

        var foundCategory = categoryService.findCategoryById(1L);

        assertNotNull(foundCategory, "Category should be found");
        assertEquals(category1.getId(), foundCategory.getId(), "Category ID should match");
        assertEquals(category1.getName(), foundCategory.getName(), "Category name should match");

        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindCategoryById_NotFound() {
        when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            categoryService.findCategoryById(999L);
        });

        assertEquals("Category not found  with ID 999", exception.getMessage(), "Exception message should match");

        verify(categoryRepository, times(1)).findById(999L);
    }

    @Test
    public void testCreateCategory() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        categoryService.createCategory(category1);

        verify(categoryRepository, times(1)).save(category1);
    }

    @Test
    public void testUpdateCategory() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        categoryService.updateCategory(category1);

        verify(categoryRepository, times(1)).save(category1);
    }

    @Test
    public void testDeleteCategory_NotFound() {
        when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            categoryService.deleteCategory(999L);
        });

        assertEquals("Category not found  with ID 999", exception.getMessage(), "Exception message should match");

        verify(categoryRepository, times(1)).findById(999L);
    }
}

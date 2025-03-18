package com.alatoo.edu.librarymanagementsystem.mapper;

import com.alatoo.edu.librarymanagementsystem.dto.CategoryDTO;
import com.alatoo.edu.librarymanagementsystem.entity.Category;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryMapperTest {

    @Test
    public void testCategoryModelToDto() {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Fiction");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Non-fiction");

        List<CategoryDTO> result = CategoryMapper.categoryModelToDto(Arrays.asList(category1, category2));

        assertNotNull(result);
        assertEquals(2, result.size());

        CategoryDTO dto1 = result.get(0);
        assertEquals(1L, dto1.getId());
        assertEquals("Fiction", dto1.getName());

        CategoryDTO dto2 = result.get(1);
        assertEquals(2L, dto2.getId());
        assertEquals("Non-fiction", dto2.getName());
    }
}

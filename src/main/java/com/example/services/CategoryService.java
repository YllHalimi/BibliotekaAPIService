package com.example.services;

import com.example.DTO.CategoryDTO;

import java.util.List;


public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}

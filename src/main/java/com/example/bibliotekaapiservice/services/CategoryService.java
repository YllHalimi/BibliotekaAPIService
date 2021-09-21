package com.example.bibliotekaapiservice.services;

import com.example.bibliotekaapiservice.DTO.CategoryDTO;

import java.util.List;


public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}

package com.example.bibliotekaapiservice.services;

import com.example.bibliotekaapiservice.DTO.CategoryDTO;
import com.example.bibliotekaapiservice.mappers.CategoryMapper;
import com.example.bibliotekaapiservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryMapper categoryMapper = null;
    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper:: categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }

    public CategoryServiceImpl( CategoryRepository categoryRepository) {
//        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;

    }
}

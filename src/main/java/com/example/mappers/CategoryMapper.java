package com.example.mappers;

import com.example.DTO.CategoryDTO;
import com.example.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(Category categoryDTO);
}


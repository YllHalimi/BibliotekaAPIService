package com.example.bibliotekaapiservice.mappers;

import com.example.bibliotekaapiservice.DTO.CategoryDTO;
import com.example.bibliotekaapiservice.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(Category categoryDTO);

}


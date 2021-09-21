package com.example.bibliotekaapiservice.mappers;

import com.example.bibliotekaapiservice.DTO.AuthorDTO;
import com.example.bibliotekaapiservice.domain.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDTO(Author author);
    Author authorDTOToAuthor(AuthorDTO authorDTO);
}

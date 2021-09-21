package com.example.bibliotekaapiservice.mappers;

import com.example.bibliotekaapiservice.DTO.BookDTO;
import com.example.bibliotekaapiservice.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
}


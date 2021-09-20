package com.example.mappers;

import com.example.DTO.BookDTO;
import com.example.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);


}


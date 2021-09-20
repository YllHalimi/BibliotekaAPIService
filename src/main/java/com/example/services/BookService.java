package com.example.services;

import com.example.DTO.BookDTO;

import java.util.List;


public interface BookService {


    void deleteBookById(Integer id);
    BookDTO getBookById(Integer id);
    List<BookDTO> getAllBooks();
    List<BookDTO> getAllBooksPaginated(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);
    BookDTO getBookByTitle(String title);
    BookDTO createNewBook(BookDTO bookDTO);
    BookDTO patchBook(Integer id, BookDTO bookDTO);
    BookDTO saveBookByDTO(Integer id, BookDTO bookDTO);
}

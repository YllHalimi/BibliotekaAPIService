package com.example.bibliotekaapiservice.services;

import com.example.bibliotekaapiservice.DTO.BookDTO;
import com.example.bibliotekaapiservice.domain.Book;
import com.example.bibliotekaapiservice.mappers.BookMapper;
import com.example.bibliotekaapiservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class BookServiceImpl implements BookService {


//    private   BookMapper bookMapper;
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    public BookServiceImpl( BookMapper bookMapper) {
//        this.bookMapper = bookMapper;
//    }


    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }


    @Override
    public BookDTO getBookById(Integer id) {
        return bookRepository.findById(id).map(book -> {
            BookDTO bookDTO = bookMapper.bookToBookDTO(book);
            bookDTO.setBookUrl("/api/books/" + book.getId());
            return bookDTO;
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getAllBooksPaginated(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
        Pageable paging = PageRequest.of(pageNo, pageSize,
                sortDirection.equals("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        Page<Book> pagedResult = bookRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            List<Book> books = pagedResult.getContent();
            return books.stream().map(book -> {
                BookDTO bookDTO = bookMapper.bookToBookDTO(book);
                bookDTO.setBookUrl("/api/books/" + book.getId());
                return bookDTO;
            }).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }



    @Override
    public BookDTO getBookByTitle(String title) {
        return bookMapper.bookToBookDTO(bookRepository.findByTitle(title));
    }

    @Override
    public BookDTO createNewBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        BookDTO returnDTO = bookMapper.bookToBookDTO(savedBook);
        returnDTO.setBookUrl("/api/books/" + savedBook.getId());
        return returnDTO;
    }

    @Override
    public BookDTO patchBook(Integer id, BookDTO bookDTO) {
        return bookRepository.findById(id).map(book -> {
            if (bookDTO.getTitle() != null) {
                book.setTitle(bookDTO.getTitle());
            }
            if (bookDTO.getIsbn() != null) {
                book.setIsbn(bookDTO.getIsbn());
            }
            if (bookDTO.getPublishedDate() != null) {
                book.setPublishedDate(bookDTO.getPublishedDate());
            }
            BookDTO returnDTO = bookMapper.bookToBookDTO(bookRepository.save(book));
            returnDTO.setBookUrl("/api/books/" + book.getId());
            return returnDTO;
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public BookDTO saveBookByDTO(Integer id, BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book.setId(id);
        Book savedBook = bookRepository.save(book);
        BookDTO returnDTO = bookMapper.bookToBookDTO(savedBook);
        returnDTO.setBookUrl("/api/books/" + savedBook.getId());
        return returnDTO;
    }
}

package com.example.bibliotekaapiservice.controllers;


import com.example.bibliotekaapiservice.DTO.BookDTO;
import com.example.bibliotekaapiservice.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
//    @Autowired
//    private final BookService bookService;

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }




   @GetMapping()
   public ResponseEntity<List<BookDTO>> getAllBooks() {
       return new ResponseEntity<List<BookDTO>>(new ArrayList<>(bookService.getAllBooks()), HttpStatus.OK);
   }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookByID(@PathVariable Integer id){
        return new ResponseEntity<BookDTO>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookDTO> getBookByTitle(@PathVariable String title) {
        return new ResponseEntity<BookDTO>(bookService.getBookByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<List<BookDTO>> getAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @RequestParam(defaultValue = "id") String sortBy,
                                                   @RequestParam(defaultValue = "DESC") String sortDirection) {

        return new ResponseEntity<List<BookDTO>>(
                new ArrayList<>(bookService.getAllBooksPaginated(pageNo, pageSize, sortBy, sortDirection)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createNewBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<BookDTO>(bookService.createNewBook(bookDTO), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<BookDTO>(bookService.saveBookByDTO(id, bookDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        bookService.deleteBookById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

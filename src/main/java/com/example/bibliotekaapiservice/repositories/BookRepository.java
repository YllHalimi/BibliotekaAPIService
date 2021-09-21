package com.example.bibliotekaapiservice.repositories;


import com.example.bibliotekaapiservice.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByTitle(String title);
    Page<Book> findAll(Pageable pageable);
//    Page<Book> findByPublishedDate(Pageable pageable);
    Page<Book> findByTitleContaining(String title, Pageable pageable);


}

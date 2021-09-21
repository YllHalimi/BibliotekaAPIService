package com.example.bibliotekaapiservice.DTO;

import com.example.bibliotekaapiservice.domain.Book;

import java.util.Set;

public class AuthorDTO {

    private String name;
    private String lastName;
    private String country;
    private Set<Book> books;
}

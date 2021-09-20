package com.example.DTO;

import com.example.domain.Author;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class BookDTO {
    private int id;
    private String title;
    private byte[] photo;
    private String isbn;
    private String BookUrl;
    private Date publishedDate;
    private Set<Author> authors;
}

package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book extends BaseEntity {

    private String title;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private byte[] photo;
    private String isbn;
    private Date publishedDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Author> authors = new HashSet<>();



}

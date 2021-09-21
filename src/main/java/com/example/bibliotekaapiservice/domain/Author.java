package com.example.bibliotekaapiservice.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "authors")
public class Author extends  BaseEntity{
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String country;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}

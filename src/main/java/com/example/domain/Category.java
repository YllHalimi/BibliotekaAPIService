package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set <Book> books = new HashSet<>();

}

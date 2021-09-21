package com.example.bibliotekaapiservice.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected int id;

    public boolean isNew(){
        return id == 0;
    }
}

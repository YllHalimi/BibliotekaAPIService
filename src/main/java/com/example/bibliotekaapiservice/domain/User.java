package com.example.bibliotekaapiservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends BaseEntity{
    private String username;
    private String date;
    private Date lastLogin;


    @OneToOne
    private Personel personel;



}

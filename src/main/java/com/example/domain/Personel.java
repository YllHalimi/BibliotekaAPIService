package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "personel")
public class Personel extends BaseEntity {

    private String name;
    private String lastname;
    private String country;
    private String municipality;
    private String address;
    private String email;
    private String phone;
    private boolean status;

    @OneToOne(mappedBy = "personel")
    private User user;

}

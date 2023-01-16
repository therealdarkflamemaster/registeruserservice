package com.example.registeruserservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private Date brithdate;

    public User(String username, Date brithdate, String residence) {
        this.username = username;
        this.brithdate = brithdate;
        this.residence = residence;
    }

    @Column(nullable = false)
    private String residence;

    private String phoneNumber;

    private String gender;


    public Date getBrithdate() {
        return brithdate;
    }

    public String getResidence() {
        return residence;
    }

}

package com.example.registeruserservice.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private Date brithdate;

    @Column(nullable = false)
    private String residence;

    @Column
    private String phoneNumber;

    @Column
    private String gender;

    public User() {

    }

    public User(String username, Date brithdate, String residence) {
        this.username = username;
        this.brithdate = brithdate;
        this.residence = residence;
    }

    public User(String username, Date brithdate, String residence, String phoneNumber, String gender) {
        this.username = username;
        this.brithdate = brithdate;
        this.residence = residence;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }



    public Date getBrithdate() {
        return brithdate;
    }

    public String getResidence() {
        return residence;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
}

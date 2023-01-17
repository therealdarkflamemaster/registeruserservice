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

    @Column(nullable = false)
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

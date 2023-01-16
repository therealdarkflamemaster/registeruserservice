package com.example.registeruserservice.repository;


import com.example.registeruserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}

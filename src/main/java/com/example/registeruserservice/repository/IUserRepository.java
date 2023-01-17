package com.example.registeruserservice.repository;


import com.example.registeruserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("FROM user u WHERE u.username = :name")
    Optional<User> findByName(String name);
}

package com.example.registeruserservice.service.intf;

import com.example.registeruserservice.model.User;
import com.example.registeruserservice.model.dto.UserException;

import java.util.Optional;

public interface IUserService {

    User register(User user) throws UserException;

    Optional<User> findUserById(Long id);
}

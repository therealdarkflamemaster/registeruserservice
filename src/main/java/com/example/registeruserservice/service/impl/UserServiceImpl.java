package com.example.registeruserservice.service.impl;


import com.example.registeruserservice.model.User;
import com.example.registeruserservice.model.dto.UserException;
import com.example.registeruserservice.repository.IUserRepository;
import com.example.registeruserservice.service.intf.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Resource
    private IUserRepository userRepository;

    @Override
    public User register(User user) throws UserException{
        if(!user.getResidence().equals("france") && !user.getResidence().equals("France")) {
            throw new UserException("Not a france residence");
        }

        // calculate the age
        LocalDate brithdate = user.getBrithdate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        if(Period.between(brithdate, LocalDate.now()).getYears() < 18) {
            throw new UserException("Not an adult");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) throws UserException{
        User result = userRepository.findById(id).orElse(null);

        if(result == null) return Optional.ofNullable(null);

        return Optional.of(result);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

}


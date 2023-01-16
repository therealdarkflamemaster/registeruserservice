package com.example.registeruserservice.controller;

import com.example.registeruserservice.model.User;
import com.example.registeruserservice.model.UserResult;
import com.example.registeruserservice.model.dto.UserException;
import com.example.registeruserservice.service.intf.IUserService;
import com.example.registeruserservice.utils.log.LogExecutionTime;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("")
    @LogExecutionTime
    public ResponseEntity addUser(@RequestBody User user) {

        try {
            User result = userService.register(user);
            return ResponseEntity.ok(result);
        }catch(UserException e) {
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @LogExecutionTime
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        Optional<User> optUser = userService.findUserById(id);
        if(optUser.isPresent()) {
            return ResponseEntity.ok(optUser.get());
        }else {
            return  new ResponseEntity<> ("User not found", HttpStatus.BAD_REQUEST);
        }
    }

}


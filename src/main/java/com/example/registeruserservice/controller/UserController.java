package com.example.registeruserservice.controller;

import com.example.registeruserservice.model.User;
import com.example.registeruserservice.model.dto.UserException;
import com.example.registeruserservice.service.intf.IUserService;
import com.example.registeruserservice.utils.log.LogExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name = "user", description = "the user API")
public class UserController {

    @Resource
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @LogExecutionTime
    @Operation(summary = "Create user", description = "Create a new user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Not an adult", content = @Content),
            @ApiResponse(responseCode = "400", description = "Not a france residence", content = @Content)
    })
    @PostMapping(value = "", consumes = { "application/json" })
    public ResponseEntity addUser(
            @Parameter(description = "Created user object") @RequestBody User user) {
        try {
            User result = userService.register(user);
            return ResponseEntity.ok(result);
        }catch(UserException e) {
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @LogExecutionTime
    @Operation(summary = "Get user by user's id", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    public ResponseEntity findUserById(
            @Parameter(description = "The id that needs to be found", required = true) @PathVariable("id") Long id) {
        Optional<User> optUser = userService.findUserById(id);
        if(optUser.isPresent()) {
            return ResponseEntity.ok(optUser.get());
        }else {
            return  new ResponseEntity<> ("User not found", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
    @LogExecutionTime
    @Operation(summary = "Get user by user's name", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    public ResponseEntity findUserByName(
            @Parameter(description = "The name that needs to be found", required = true) @PathVariable("name") String name) {
        Optional<User> users = userService.findUserByName(name);
        if(!users.isEmpty()) {
            return ResponseEntity.ok(users);
        }else {
            return  new ResponseEntity<> ("User not found", HttpStatus.BAD_REQUEST);
        }
    }

}


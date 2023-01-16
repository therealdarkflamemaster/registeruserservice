package com.example.registeruserservice.model.dto;

public class UserException extends RuntimeException{
    private String msg;

    public UserException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}

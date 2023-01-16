package com.example.registeruserservice.model;

public class UserResult {

    private String message;
    private boolean isSuccess;

    private User data;

    public void setUserResultSuccess(String message, User data) {
        this.message = message;
        this.isSuccess = true;
        this.data = data;
    }

    public void setUserResultFailed(String message) {
        this.message = message;
        this.isSuccess = false;
        this.data = null;
    }
}

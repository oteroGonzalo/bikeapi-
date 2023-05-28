package com.gonzalo.bikeapi.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("The user: " + id + " has not been found");
    }
}

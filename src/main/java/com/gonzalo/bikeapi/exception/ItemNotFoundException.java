package com.gonzalo.bikeapi.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super("The item with id: " + id + " has not been found");
    }
    
}

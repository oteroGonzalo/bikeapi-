package com.gonzalo.bikeapi.exception;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(Long id) {
        super("The bike with id: " + id + " has not been found");
    }
    
}

package com.gonzalo.bikeapi.exception;

public class BikeWithItemNotFoundException extends RuntimeException{
    
    public BikeWithItemNotFoundException(String type) {
        super("No bikes with the item: " + type + " has been found");
    }
}

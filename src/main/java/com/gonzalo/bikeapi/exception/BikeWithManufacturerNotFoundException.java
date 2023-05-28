package com.gonzalo.bikeapi.exception;

public class BikeWithManufacturerNotFoundException extends RuntimeException {
    public BikeWithManufacturerNotFoundException(String manufacturer) {
        super("The bike with manufacturer: " + manufacturer + " has not been found");
    }
}

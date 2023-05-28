package com.gonzalo.bikeapi.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String message;
}

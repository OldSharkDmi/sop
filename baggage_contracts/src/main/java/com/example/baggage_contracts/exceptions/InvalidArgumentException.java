package com.example.baggage_contracts.exceptions;


public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message) {
        super("Invalid request: " + message);
    }
}

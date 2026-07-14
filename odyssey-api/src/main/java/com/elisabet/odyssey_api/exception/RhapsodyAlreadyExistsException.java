package com.elisabet.odyssey_api.exception;

public class RhapsodyAlreadyExistsException extends RuntimeException {
    public RhapsodyAlreadyExistsException(Integer number) {
        super("Rhapsody '" + number + "' already exists.");
    }
}

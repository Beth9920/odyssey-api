package com.elisabet.odyssey_api.exception;

public class PlaceAlreadyExistsException extends RuntimeException {

    public PlaceAlreadyExistsException(String name) {
        super("Place '" + name + "' already exists.");
    }
}
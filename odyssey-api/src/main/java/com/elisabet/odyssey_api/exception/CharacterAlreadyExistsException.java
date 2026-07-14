package com.elisabet.odyssey_api.exception;

import com.elisabet.odyssey_api.exception.CharacterAlreadyExistsException;

public class CharacterAlreadyExistsException extends RuntimeException {

    public CharacterAlreadyExistsException(String name) {
        super("Character '" + name + "' already exists.");
    }
}
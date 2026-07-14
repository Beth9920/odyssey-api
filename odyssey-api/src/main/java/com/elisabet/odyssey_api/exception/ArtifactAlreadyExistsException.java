package com.elisabet.odyssey_api.exception;

public class ArtifactAlreadyExistsException extends RuntimeException {
    public ArtifactAlreadyExistsException(String name) {
        super("Artifact '" + name + "' already exists.");
    }
}

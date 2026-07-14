package com.elisabet.odyssey_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CharacterAlreadyExistsException.class)
    public ResponseEntity<String> handleCharacterAlreadyExists(
            CharacterAlreadyExistsException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PlaceAlreadyExistsException.class)
    public ResponseEntity<String> handlePlaceAlreadyExists(
            PlaceAlreadyExistsException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ArtifactAlreadyExistsException.class)
    public ResponseEntity<String> handleArtifactAlreadyExists(
            ArtifactAlreadyExistsException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RhapsodyAlreadyExistsException.class)
    public ResponseEntity<String> handleRhapsodyAlreadyExists(
            RhapsodyAlreadyExistsException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
package com.example.crud.infra;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> threat404(){
        ExceptionDTO response = new ExceptionDTO("Data not found with provided ID", 404);
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExceptionDTO> ProductAlreadyExistsException(){
        ExceptionDTO response = new ExceptionDTO("Product already exists!", 409);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDTO> invalidPricing(){
        ExceptionDTO response = new ExceptionDTO("Value Invalid!", 400);
        return ResponseEntity.badRequest().body(response);
    }
}
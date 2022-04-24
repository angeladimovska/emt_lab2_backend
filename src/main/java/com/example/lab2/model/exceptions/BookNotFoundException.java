package com.example.lab2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super(String.format("Author with id: %d is not found", id));
    }
}


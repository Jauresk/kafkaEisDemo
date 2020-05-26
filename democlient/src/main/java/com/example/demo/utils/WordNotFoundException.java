package com.example.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WordNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WordNotFoundException(String message) {
        super(message);
    }
}

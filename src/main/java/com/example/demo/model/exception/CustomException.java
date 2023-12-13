package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomException extends RuntimeException {

    private static String MESSAGE = "Custom exception message";

    public CustomException() {
        super(MESSAGE);
    }
}

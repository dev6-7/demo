package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WritingCsvFileException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Error occurred while writing CSV file";

    public WritingCsvFileException() {
        super(DEFAULT_MESSAGE);
    }
}

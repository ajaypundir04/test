package com.flink.test.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseStatusException handleException(Exception e) {
        return new ResponseStatusException(HttpStatusCode.valueOf(500), "Unable to process the request");
    }

    @ExceptionHandler
    public ResponseStatusException handleMethodArgumentException(MethodArgumentNotValidException e) {
        return new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
    }

    @ExceptionHandler
    public ResponseStatusException handleLocationException(LocationNotFoundException e) {
        return new ResponseStatusException(HttpStatusCode.valueOf(404), e.getMessage());
    }

}

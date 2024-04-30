package com.ianua.api.gateway.configuration.administration.exception.controller;

import com.ianua.api.gateway.configuration.administration.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException apiException) {
        Map<String, Object> body = new HashMap<>();

        body.put("message", apiException.getErrorMessage());
        body.put("title", apiException.errorTitle());
        body.put("status", apiException.getStatusCode().value());

        return new ResponseEntity<>(body, apiException.getStatusCode());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleApiException(Throwable throwable) {
        Map<String, Object> body = new HashMap<>();

        body.put("message", "An exception that was not expected has ocurred");
        body.put("title", "UnhandledException");
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        throwable.printStackTrace();

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

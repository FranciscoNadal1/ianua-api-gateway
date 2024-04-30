package com.ianua.api.gateway.configuration.administration.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException{
    HttpStatus statusCode = HttpStatus.BAD_REQUEST;

    String errorTitle = "ApiException";

    String errorMessage = "An api exception has occurred";

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String errorTitle() {
        return errorTitle;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

package com.ianua.api.gateway.configuration.administration.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends ApiException{

    protected final HttpStatus STATUS_CODE = HttpStatus.UNPROCESSABLE_ENTITY;

    protected final String ERROR_TITLE = "ObjectNotFoundException";

    protected final String ERROR_MESSAGE = "Invalid id was provided";

    public ObjectNotFoundException() {
        super();

        statusCode = STATUS_CODE;
        errorTitle = ERROR_TITLE;
        errorMessage = ERROR_MESSAGE;
    }
}

package com.ianua.api.gateway.configuration.administration.exception;

import org.springframework.http.HttpStatus;

public class SerializationException extends ApiException{

    protected final HttpStatus STATUS_CODE = HttpStatus.INTERNAL_SERVER_ERROR;

    protected final String ERROR_TITLE = "SerializationException";

    protected final String ERROR_MESSAGE = "Response from server returned an invalid format";

    public SerializationException() {
        super();

        statusCode = STATUS_CODE;
        errorTitle = ERROR_TITLE;
        errorMessage = ERROR_MESSAGE;
    }
}

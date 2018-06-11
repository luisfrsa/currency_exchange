package com.currency.exchange.Currency.Exchange.exception;



import org.springframework.http.HttpStatus;

public class ApplicationServiceException extends RuntimeException{

    private final HttpStatus status;

    public ApplicationServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ApplicationServiceException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public ApplicationServiceException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

package com.user.microservice.domain.exception;

public class NullFieldException extends RuntimeException {
    public NullFieldException(String message) {
        super(message);
    }
}

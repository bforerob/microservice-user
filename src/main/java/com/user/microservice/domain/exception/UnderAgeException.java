package com.user.microservice.domain.exception;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException(String message) {
        super(message);
    }
}

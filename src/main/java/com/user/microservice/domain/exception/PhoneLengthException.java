package com.user.microservice.domain.exception;

public class PhoneLengthException extends RuntimeException {
    public PhoneLengthException(String message) {
        super(message);
    }
}

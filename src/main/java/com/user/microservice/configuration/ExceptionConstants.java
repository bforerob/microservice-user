package com.user.microservice.configuration;

public class ExceptionConstants {

    private ExceptionConstants() { throw new IllegalStateException("Utility class"); }

    public static final String INVALID_EMAIL_FORMAT_EXCEPTION_MESSAGE = "Invalid email format";
    public static final String PHONE_NUMBER_LENGTH_EXCEPTION_MESSAGE = "max phone number length is %s";
    public static final String INVALID_PHONE_FORMAT_EXCEPTION_MESSAGE = "Invalid phone format";
    public static final String UNDER_AGE_USER_EXCEPTION_MESSAGE = "you need to be %s years old";
    public static final String NON_NUMERICAL_DOCUMENT_ID_EXCEPTION_MESSAGE = "document id must be numeric";
    public static final String EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE = "An user with this %s already exists";
    public static final String NULL_FIELD_EXCEPTION_MESSAGE = "%s can not be null";

}

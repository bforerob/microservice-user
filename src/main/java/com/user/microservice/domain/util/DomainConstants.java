package com.user.microservice.domain.util;

public class DomainConstants {

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field{
        CATEGORY,
    }


    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    public static final String PHONE_REGEX = "^\\+?[0-9]{1,13}$";
    public static final int LEGAL_AGE = 18;
    public static final int PHONE_NUMBER_MAX_LENGTH = 13;
    public static final String DOCUMENT_REGEX = "\\d+";



}

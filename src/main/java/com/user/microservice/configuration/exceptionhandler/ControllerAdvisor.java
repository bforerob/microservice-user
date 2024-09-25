package com.user.microservice.configuration.exceptionhandler;

import com.user.microservice.configuration.ExceptionConstants;
import com.user.microservice.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(PhoneLengthException.class)
    public ResponseEntity<ExceptionResponse> handlePhoneLengthException(PhoneLengthException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ExceptionConstants.PHONE_NUMBER_LENGTH_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(UnderAgeException.class)
    public ResponseEntity<ExceptionResponse> handleUnderAgeException(UnderAgeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ExceptionConstants.UNDER_AGE_USER_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleAlreadyExistsException(AlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ExceptionConstants.EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<ExceptionResponse> handleNullFieldException(NullFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ExceptionConstants.NULL_FIELD_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }


    @ExceptionHandler(InvalidEmailFormatException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidEmailFormatException(InvalidEmailFormatException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                ExceptionConstants.INVALID_EMAIL_FORMAT_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(PhoneFormatException.class)
    public ResponseEntity<ExceptionResponse> handlePhoneFormatException(PhoneFormatException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                ExceptionConstants.INVALID_PHONE_FORMAT_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NonNumericDocumentIdException.class)
    public ResponseEntity<ExceptionResponse> handleNonNumericDocumentIdException(NonNumericDocumentIdException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                ExceptionConstants.NON_NUMERICAL_DOCUMENT_ID_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }



}

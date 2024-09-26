package com.user.microservice.domain.model;

import com.user.microservice.domain.exception.NullFieldException;
import com.user.microservice.domain.util.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("given a user with a null name, User constructor should throw NullFieldException")
    void when_UserNameIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, null, "Doe", "123456789", "1234567890", LocalDate.of(1990, 1, 1), "johndoe@example.com", "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when name is null");
    }

    @Test
    @DisplayName("given a user with a null lastName, User constructor should throw NullFieldException")
    void when_UserLastNameIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", null, "123456789", "1234567890", LocalDate.of(1990, 1, 1), "johndoe@example.com", "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when lastName is null");
    }

    @Test
    @DisplayName("given a user with a null documentId, User constructor should throw NullFieldException")
    void when_UserDocumentIdIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", null, "1234567890", LocalDate.of(1990, 1, 1), "johndoe@example.com", "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when documentId is null");
    }

    @Test
    @DisplayName("given a user with a null phoneNumber, User constructor should throw NullFieldException")
    void when_UserPhoneNumberIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", "123456789", null, LocalDate.of(1990, 1, 1), "johndoe@example.com", "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when phoneNumber is null");
    }

    @Test
    @DisplayName("given a user with a null birthDate, User constructor should throw NullFieldException")
    void when_UserBirthDateIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", "123456789", "1234567890", null, "johndoe@example.com", "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when birthDate is null");
    }

    @Test
    @DisplayName("given a user with a null email, User constructor should throw NullFieldException")
    void when_UserEmailIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", "123456789", "1234567890", LocalDate.of(1990, 1, 1), null, "password", Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when email is null");
    }

    @Test
    @DisplayName("given a user with a null password, User constructor should throw NullFieldException")
    void when_UserPasswordIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", "123456789", "1234567890", LocalDate.of(1990, 1, 1), "johndoe@example.com", null, Role.AUX_BODEGA),
                "User constructor did not throw the expected NullFieldException when password is null");
    }

    @Test
    @DisplayName("given a user with a null role, User constructor should throw NullFieldException")
    void when_UserRoleIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new User(
                        1L, "John", "Doe", "123456789", "1234567890", LocalDate.of(1990, 1, 1), "johndoe@example.com", "password", null),
                "User constructor did not throw the expected NullFieldException when role is null");
    }

}
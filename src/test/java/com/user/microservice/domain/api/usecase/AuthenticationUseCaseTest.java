package com.user.microservice.domain.api.usecase;

import com.user.microservice.domain.exception.*;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import com.user.microservice.domain.util.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationUseCaseTest {

    @Mock
    private IAuthenticationPersistencePort authenticationPersistencePort;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationUseCase authenticationUseCase;

    @Test
    @DisplayName("Should register a user successfully when all inputs are valid")
    void When_UserInformationIsCorrect_Expect_UserRegisteredSuccessfully() {
        User user = new User(1L, "John", "Doe", "123456789", "+123456789", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(authenticationPersistencePort.register(user)).thenReturn(user);

        User result = authenticationUseCase.register(user);

        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals("encodedPassword", result.getPassword());
        verify(authenticationPersistencePort, times(1)).register(user);
    }

    @Test
    @DisplayName("Should throw EmptyFieldException when user has an empty name")
    void Expect_EmptyFieldException_When_UserNameIsEmpty() {
        User user = new User(1L, "", "Doe", "123456789", "+123456789", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        assertThrows(EmptyFieldException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected EmptyFieldException when name is empty");
    }

    @Test
    @DisplayName("Should throw InvalidEmailFormatException when email format is invalid")
    void Expect_InvalidEmailFormatException_When_EmailFormatIsInvalid() {
        User user = new User(1L, "John", "Doe", "123456789", "+123456789", LocalDate.of(1990, 1, 1), "invalid-email", "password123", Role.AUX_BODEGA);

        assertThrows(InvalidEmailFormatException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected InvalidEmailFormatException when email format is invalid");
    }

    @Test
    @DisplayName("Should throw AlreadyExistsException when email already exists")
    void Expect_AlreadyExistsException_When_EmailAlreadyExists() {
        User user = new User(1L, "John", "Doe", "123456789", "+123456789", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        when(authenticationPersistencePort.existsByEmail(user.getEmail())).thenReturn(true);

        assertThrows(AlreadyExistsException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected AlreadyExistsException when email already exists");
    }

    @Test
    @DisplayName("Should throw PhoneLengthException when phone number exceeds maximum length")
    void Expect_PhoneLengthException_When_PhoneNumberExceedsMaxLength() {
        String longPhoneNumber = "+12345678901234";
        User user = new User(1L, "John", "Doe", "123456789", longPhoneNumber, LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        assertThrows(PhoneLengthException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected PhoneLengthException when phone number exceeds maximum length");
    }

    @Test
    @DisplayName("Should throw PhoneFormatException when phone number format is invalid")
    void Expect_PhoneFormatException_When_PhoneNumberIsInvalid() {
        User user = new User(1L, "John", "Doe", "123456789", "a123456789", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        assertThrows(PhoneFormatException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected PhoneFormatException when phone number format is invalid");
    }

    @Test
    @DisplayName("Should throw NonNumericDocumentIdException when document ID is not numeric")
    void Expect_NonNumericDocumentIdException_When_DocumentIdIsNonNumeric() {
        User user = new User(1L, "John", "Doe", "abc123", "+123456789", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        assertThrows(NonNumericDocumentIdException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected NonNumericDocumentIdException when document ID is not numeric");
    }

    @Test
    @DisplayName("Should throw UnderAgeException when user is under legal age")
    void Expect_UnderAgeException_When_UserIsUnderAge() {
        User user = new User(1L, "John", "Doe", "123456789", "+123456789", LocalDate.of(2010, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        assertThrows(UnderAgeException.class, () -> authenticationUseCase.register(user),
                "register did not throw the expected UnderAgeException when user is under legal age");
    }
}

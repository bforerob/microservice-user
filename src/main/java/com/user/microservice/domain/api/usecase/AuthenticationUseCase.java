package com.user.microservice.domain.api.usecase;


import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.exception.*;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import com.user.microservice.domain.util.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.regex.Pattern;

import static com.user.microservice.domain.util.DomainConstants.*;


public class AuthenticationUseCase implements IAuthenticationServicePort {

    private final IAuthenticationPersistencePort authenticationPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationUseCase(IAuthenticationPersistencePort authenticationPersistencePort, PasswordEncoder passwordEncoder) {
        this.authenticationPersistencePort = authenticationPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        return authenticationPersistencePort.login(authenticationRequest);

    }

    @Override
    public User register(User user) {

        Map<String, String> fields = Map.of(
                Field.NAME.toString(), user.getName(),
                Field.LAST_NAME.toString(), user.getLastName(),
                Field.DOCUMENT_ID.toString(), user.getDocumentId(),
                Field.PHONE_NUMBER.toString(), user.getPhoneNumber(),
                Field.EMAIL.toString(), user.getEmail(),
                Field.PASSWORD.toString(), user.getPassword(),
                Field.ROLE.toString(), user.getRole().name()
        );

        fields.forEach((field, value) -> {
            if (value.trim().isEmpty()) {
                throw new EmptyFieldException(field);
            }
        });
        if (!Pattern.matches(EMAIL_REGEX, user.getEmail())) {
            throw new InvalidEmailFormatException();
        }

        if(Boolean.TRUE.equals(authenticationPersistencePort.existsByEmail(user.getEmail()))) {
            throw new AlreadyExistsException(Field.EMAIL.toString());
        }

        if (user.getPhoneNumber().length()> MAX_PHONE_NUMBER_LENGTH) {
            throw new PhoneLengthException(MAX_PHONE_NUMBER_LENGTH.toString());
        }

        if (!Pattern.matches(PHONE_REGEX, user.getPhoneNumber())) {
            throw new PhoneFormatException();
        }
        if (!user.getDocumentId().matches(DOCUMENT_REGEX)) {
            throw new NonNumericDocumentIdException();
        }
        if (Period.between(user.getBirthDate(), LocalDate.now()).getYears() < LEGAL_AGE) {
            throw new UnderAgeException(LEGAL_AGE.toString());
        }


        user.setRole(Role.AUX_BODEGA);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authenticationPersistencePort.register(user);

    }

}

package com.user.microservice.domain.api.usecase;


import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import com.user.microservice.domain.util.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
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

        if (!Pattern.matches(EMAIL_REGEX, user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (user.getPhoneNumber().length()>PHONE_NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid phone lenght");
        }

        if (!Pattern.matches(PHONE_REGEX, user.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone format");
        }
        if (!user.getDocumentId().matches(DOCUMENT_REGEX)) {
            throw new IllegalArgumentException("Document ID must be numeric");
        }
        if (Period.between(user.getBirthDate(), LocalDate.now()).getYears() < LEGAL_AGE) {
            throw new IllegalArgumentException("User must be at least 18 years old");
        }


        user.setRole(Role.AUX_BODEGA);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authenticationPersistencePort.register(user);

    }

}

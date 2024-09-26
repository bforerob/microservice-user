package com.user.microservice.domain.spi;

import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.model.User;

public interface IAuthenticationPersistencePort {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    User register(User user);

    Boolean existsByEmail(String email);
}

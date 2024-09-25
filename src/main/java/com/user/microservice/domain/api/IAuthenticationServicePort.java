package com.user.microservice.domain.api;

import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.request.RegisterRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.model.User;

public interface IAuthenticationServicePort {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    User register(User user);
}

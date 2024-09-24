package com.user.microservice.domain.api;

import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;

public interface IAuthenticationServicePort {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}

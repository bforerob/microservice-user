package com.user.microservice.domain.api;

import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.util.Role;

public interface IAuthenticationServicePort {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    User register(User user, Role role);
}

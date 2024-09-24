package com.user.microservice.domain.api.useCase;


import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;


public class AuthenticationUseCase implements IAuthenticationServicePort {

    private final IAuthenticationPersistencePort authenticationPersistencePort;

    public AuthenticationUseCase(IAuthenticationPersistencePort authenticationPersistencePort) {
        this.authenticationPersistencePort = authenticationPersistencePort;
    }


    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        return authenticationPersistencePort.login(authenticationRequest);

    }

}

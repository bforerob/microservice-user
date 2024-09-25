package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.request.RegisterRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.adapters.driving.http.dto.response.RegisterResponse;
import com.user.microservice.adapters.driving.http.mapper.request.IRegisterUserRequestMapper;
import com.user.microservice.adapters.driving.http.mapper.response.IRegisterUserResponseMapper;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestControllerAdapter {

    private final IAuthenticationServicePort authenticationServicePort;
    private final IRegisterUserRequestMapper registerUserRequestMapper;
    private final IRegisterUserResponseMapper registerUserResponseMapper;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {

        AuthenticationResponse jwtDto = authenticationServicePort.login(authenticationRequest);

        return ResponseEntity.ok(jwtDto);
    }

    @PostMapping("/registerAux")
    public ResponseEntity<RegisterResponse> registerAux(
            @RequestBody RegisterRequest registerRequest
    ) {

        User registeredAux = authenticationServicePort.register(registerUserRequestMapper.userRequestToUser(registerRequest));

        return  ResponseEntity.ok(registerUserResponseMapper.userToRegisterResponse(registeredAux));
    }

}

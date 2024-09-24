package com.user.microservice.adapters.driven.jpa.mysql.adapter;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.configuration.security.jwtconfiguration.JwtService;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.HashMap;
import java.util.Map;


public class AuthenticationAdapter implements IAuthenticationPersistencePort {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository iUserRepository;
    private final JwtService jwtService;


    public AuthenticationAdapter(AuthenticationManager authenticationManager, IUserRepository iUserRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.iUserRepository = iUserRepository;
        this.jwtService = jwtService;
    }


    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        UserEntity user = iUserRepository.findByEmail(authenticationRequest.getEmail()).get();
        String jwt = jwtService.generateToken(generateExtraClaims(user), user);
        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(UserEntity user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());


        return extraClaims;

    }

}

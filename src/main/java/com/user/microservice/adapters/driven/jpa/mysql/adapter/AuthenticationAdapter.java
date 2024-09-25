package com.user.microservice.adapters.driven.jpa.mysql.adapter;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.adapters.driving.http.dto.request.AuthenticationRequest;
import com.user.microservice.adapters.driving.http.dto.response.AuthenticationResponse;
import com.user.microservice.configuration.security.jwtconfiguration.JwtService;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.HashMap;
import java.util.Map;


public class AuthenticationAdapter implements IAuthenticationPersistencePort {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final IUserEntityMapper userEntityMapper;


    public AuthenticationAdapter(AuthenticationManager authenticationManager, IUserRepository iUserRepository, JwtService jwtService, IUserEntityMapper userEntityMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = iUserRepository;
        this.jwtService = jwtService;
        this.userEntityMapper = userEntityMapper;
    }


    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        UserEntity user = userRepository.findByEmail(authenticationRequest.getEmail()).get();
        String jwt = jwtService.generateToken(generateExtraClaims(user), user);
        return new AuthenticationResponse(jwt);
    }

    @Override
    public User register(User user) {

        UserEntity savedUser = userRepository.save(userEntityMapper.userToUserEntity(user));
        return userEntityMapper.userEntityToUser(savedUser);

    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private Map<String, Object> generateExtraClaims(UserEntity user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());


        return extraClaims;

    }

}

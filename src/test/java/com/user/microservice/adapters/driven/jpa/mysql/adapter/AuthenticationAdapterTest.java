package com.user.microservice.adapters.driven.jpa.mysql.adapter;

import static org.mockito.Mockito.*;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.configuration.security.jwtconfiguration.JwtService;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.util.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationAdapterTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private IUserEntityMapper userEntityMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationAdapter authenticationAdapter;

    @Test
    @DisplayName("Given a user, the user should be registered correctly")
    void When_UserIsCorrect_Expect_UserRegisteredSuccessfully() {

        User user = new User(1L, "John", "Doe", "123456789", "+1234567890", LocalDate.of(2000, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);
        UserEntity userEntity = new UserEntity(1L, "John", "Doe", "123456789", "+1234567890", LocalDate.of(2000, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);

        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(userEntityMapper.userToUserEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userEntityMapper.userEntityToUser(userEntity)).thenReturn(user);

        User result = authenticationAdapter.register(user);

        assertEquals(result, user, "User was not registered correctly");
        verify(userRepository).save(userEntity);
        verify(userEntityMapper).userEntityToUser(userEntity);
    }

    @Test
    @DisplayName("Given an email, should return true if user exists")
    void When_EmailExists_Expect_True() {
        String email = "john.doe@example.com";

        when(userRepository.existsByEmail(email)).thenReturn(true);

        Boolean result = authenticationAdapter.existsByEmail(email);

        assertTrue(result, "Email should exist");
        verify(userRepository).existsByEmail(email);
    }

}


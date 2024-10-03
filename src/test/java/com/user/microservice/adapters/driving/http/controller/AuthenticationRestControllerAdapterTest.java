package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.adapters.driving.http.dto.request.RegisterRequest;
import com.user.microservice.adapters.driving.http.dto.response.RegisterResponse;
import com.user.microservice.adapters.driving.http.mapper.request.IRegisterUserRequestMapper;
import com.user.microservice.adapters.driving.http.mapper.response.IRegisterUserResponseMapper;
import com.user.microservice.configuration.security.jwtconfiguration.JwtService;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.util.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationRestControllerAdapter.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthenticationRestControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAuthenticationServicePort authenticationServicePort;

    @MockBean
    private IRegisterUserRequestMapper registerUserRequestMapper;

    @MockBean
    private IRegisterUserResponseMapper registerUserResponseMapper;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private IUserRepository userRepository;

    @Test
    @DisplayName("Given a valid register request, should register aux and return RegisterResponse with status OK")
    void When_RegisterRequestIsValid_Expect_ReturnOkStatusAndRegisterResponse() throws Exception {
        User user = new User(1L, "John", "Doe", "123456789", "+1234567890", LocalDate.of(2000, 1, 1), "john.doe@example.com", "password123", Role.AUX_BODEGA);
        RegisterResponse registerResponse = new RegisterResponse( "John", "Doe", "123456789", "+1234567890", LocalDate.of(2000, 1, 1), "john.doe@example.com");

        when(registerUserRequestMapper.userRequestToUser(any(RegisterRequest.class))).thenReturn(user);
        when(authenticationServicePort.register(any(User.class), eq(Role.AUX_BODEGA))).thenReturn(user);
        when(registerUserResponseMapper.userToRegisterResponse(any(User.class))).thenReturn(registerResponse);

        mockMvc.perform(post("/auth/register/aux")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\",\"lastName\":\"Doe\",\"documentId\":\"123456789\",\"phoneNumber\":\"+1234567890\",\"email\":\"john.doe@example.com\",\"password\":\"password123\",\"birthDate\":\"2000-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));

        verify(registerUserRequestMapper).userRequestToUser(any(RegisterRequest.class));
        verify(authenticationServicePort).register(any(User.class), eq(Role.AUX_BODEGA));
        verify(registerUserResponseMapper).userToRegisterResponse(any(User.class));
    }

    @Test
    @DisplayName("Given a valid register request for customer, should register customer and return RegisterResponse with status OK")
    void When_RegisterCustomerRequestIsValid_Expect_ReturnOkStatusAndRegisterResponse() throws Exception {

        User user = new User(2L, "Jane", "Doe", "987654321", "+9876543210", LocalDate.of(1995, 5, 15), "jane.doe@example.com", "password123", Role.CUSTOMER);
        RegisterResponse registerResponse = new RegisterResponse("Jane", "Doe", "987654321", "+9876543210", LocalDate.of(1995, 5, 15), "jane.doe@example.com");

        when(registerUserRequestMapper.userRequestToUser(any(RegisterRequest.class))).thenReturn(user);
        when(authenticationServicePort.register(any(User.class), eq(Role.CUSTOMER))).thenReturn(user);
        when(registerUserResponseMapper.userToRegisterResponse(any(User.class))).thenReturn(registerResponse);

        mockMvc.perform(post("/auth/register/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Jane\",\"lastName\":\"Doe\",\"documentId\":\"987654321\",\"phoneNumber\":\"+9876543210\",\"email\":\"jane.doe@example.com\",\"password\":\"password123\",\"birthDate\":\"1995-05-15\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("jane.doe@example.com"));

        verify(registerUserRequestMapper).userRequestToUser(any(RegisterRequest.class));
        verify(authenticationServicePort).register(any(User.class), eq(Role.CUSTOMER));
        verify(registerUserResponseMapper).userToRegisterResponse(any(User.class));
    }

}

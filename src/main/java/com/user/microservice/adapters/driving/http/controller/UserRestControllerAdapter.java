package com.user.microservice.adapters.driving.http.controller;


import com.user.microservice.adapters.driving.http.dto.request.AddUserRequest;
import com.user.microservice.adapters.driving.http.dto.response.UserResponse;
import com.user.microservice.adapters.driving.http.mapper.request.IUserRequestMapper;
import com.user.microservice.adapters.driving.http.mapper.response.IUserResponseMapper;
import com.user.microservice.domain.api.IUserServicePort;
import com.user.microservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserRestControllerAdapter {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @PostMapping("/createAux")
    public ResponseEntity<UserResponse> createAuxUser(@RequestBody AddUserRequest addUserRequest) {

        User createdUser = userServicePort.createAuxUser(userRequestMapper.addUserRequestToUser(addUserRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseMapper.userToUserResponse(createdUser));

    }



}

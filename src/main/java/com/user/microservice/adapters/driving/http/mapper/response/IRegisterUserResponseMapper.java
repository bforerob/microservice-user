package com.user.microservice.adapters.driving.http.mapper.response;

import com.user.microservice.adapters.driving.http.dto.response.RegisterResponse;
import com.user.microservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRegisterUserResponseMapper {

    RegisterResponse userToRegisterResponse(User user);

}

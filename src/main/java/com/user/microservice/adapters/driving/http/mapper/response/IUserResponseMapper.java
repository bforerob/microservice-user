package com.user.microservice.adapters.driving.http.mapper.response;

import com.user.microservice.adapters.driving.http.dto.response.UserResponse;
import com.user.microservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserResponseMapper {

    UserResponse userToUserResponse(User user);

}

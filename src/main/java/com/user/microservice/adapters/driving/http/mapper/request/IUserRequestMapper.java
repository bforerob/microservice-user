package com.user.microservice.adapters.driving.http.mapper.request;

import com.user.microservice.adapters.driving.http.dto.request.AddUserRequest;
import com.user.microservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User addUserRequestToUser(AddUserRequest addUserRequest);

}

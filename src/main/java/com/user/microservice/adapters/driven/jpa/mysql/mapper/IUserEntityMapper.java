package com.user.microservice.adapters.driven.jpa.mysql.mapper;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.microservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {

    User userEntityToUser(UserEntity userEntity);
    UserEntity userToUserEntity(User user);
}

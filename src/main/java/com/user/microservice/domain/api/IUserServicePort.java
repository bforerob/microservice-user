package com.user.microservice.domain.api;

import com.user.microservice.domain.model.User;

public interface IUserServicePort {

    User createAuxUser(User user);

}

package com.user.microservice.domain.spi;

import com.user.microservice.domain.model.User;

public interface IUserPersistencePort {

    User createAuxUser(User user);


}

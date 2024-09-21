package com.user.microservice.domain.api.usecase;

import com.user.microservice.domain.api.IUserServicePort;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IUserPersistencePort;

import static com.user.microservice.domain.util.DomainConstants.AUX_USER_ROLE_ID;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User createAuxUser(User user) {
        user.setRole(AUX_USER_ROLE_ID);
        return userPersistencePort.createAuxUser(user);
    }
}

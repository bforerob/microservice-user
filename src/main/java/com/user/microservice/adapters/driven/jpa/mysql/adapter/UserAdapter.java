package com.user.microservice.adapters.driven.jpa.mysql.adapter;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.domain.model.User;
import com.user.microservice.domain.spi.IUserPersistencePort;

public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    public UserAdapter(IUserRepository userRepository, IUserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createAuxUser(User user) {

        UserEntity savedUser = userRepository.save(userEntityMapper.userToUserEntity(user));
        return userEntityMapper.userEntityToUser(savedUser);

    }
}

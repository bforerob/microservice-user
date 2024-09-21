package com.user.microservice.adapters.driven.jpa.mysql.repository;

import com.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {



}

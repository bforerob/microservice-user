package com.user.microservice.domain.model;


import com.user.microservice.domain.exception.NullFieldException;
import com.user.microservice.domain.util.DomainConstants;

import java.util.Objects;

public class Brand {

    private final Long id;
    private final String name;
    private final String description;

    public Brand(Long id, String name, String description) {

        this.id = id;
        this.name = Objects.requireNonNull(name, () -> {
            throw new NullFieldException(DomainConstants.Field.NAME.toString());
        });
        this.description = Objects.requireNonNull(description, () -> {
            throw new NullFieldException(DomainConstants.Field.DESCRIPTION.toString());
        });

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

}

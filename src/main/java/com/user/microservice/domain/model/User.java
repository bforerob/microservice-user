package com.user.microservice.domain.model;

import com.user.microservice.domain.exception.NullFieldException;
import com.user.microservice.domain.util.DomainConstants;
import com.user.microservice.domain.util.Role;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private final Long id;
    private final String name;
    private final String lastName;
    private final String documentId;
    private final String phoneNumber;
    private final LocalDate birthDate;
    private final String email;
    private String password;
    private Role role;

    public User(Long id, String name, String lastName, String documentId, String phoneNumber, LocalDate birthDate, String email, String password, Role role) {
        this.id = id;
        this.name = Objects.requireNonNull(name, () -> {
            throw new NullFieldException(DomainConstants.Field.NAME.toString());
        });
        this.lastName = Objects.requireNonNull(lastName, () -> {
            throw new NullFieldException(DomainConstants.Field.LAST_NAME.toString());
        });
        this.documentId = Objects.requireNonNull(documentId, () -> {
            throw new NullFieldException(DomainConstants.Field.DOCUMENT_ID.toString());
        });
        this.phoneNumber = Objects.requireNonNull(phoneNumber, () -> {
            throw new NullFieldException(DomainConstants.Field.PHONE_NUMBER.toString());
        });
        this.birthDate = Objects.requireNonNull(birthDate, () -> {
            throw new NullFieldException(DomainConstants.Field.BIRTH_DATE.toString());
        });
        this.email = Objects.requireNonNull(email, () -> {
            throw new NullFieldException(DomainConstants.Field.EMAIL.toString());
        });
        this.password = Objects.requireNonNull(password, () -> {
            throw new NullFieldException(DomainConstants.Field.PASSWORD.toString());
        });
        this.role = Objects.requireNonNull(role, () -> {
            throw new NullFieldException(DomainConstants.Field.ROLE.toString());
        });
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

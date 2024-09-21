package com.user.microservice.domain.model;

import java.time.LocalDate;

public class User {

    private final Long id;
    private final String name;
    private final String lastName;
    private final String documentId;
    private final String phoneNumber;
    private final LocalDate birthDate;
    private final String email;
    private final String encryptedPassword;
    private Integer role;

    public User(Long id, String name, String lastName, String documentId, String phoneNumber, LocalDate birthDate, String email, String encryptedPassword, Integer role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.role = role;
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}

package com.user.microservice.domain.model;

import java.util.Date;

public class User {

    Long id;
    String name;
    String lastName;
    String documentId;
    String phoneNumber;
    Date birthDate;
    String email;
    String password;

    public User(Long id, String name, String lastName, String documentId, String phoneNumber, Date birthDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

package com.user.microservice.domain.model;

import com.user.microservice.domain.util.Role;

import java.time.LocalDate;
import java.util.Date;

public class User {

    Long id;
    String name;
    String lastName;
    String documentId;
    String phoneNumber;
    LocalDate birthDate;
    String email;
    String password;
    Role role;

    public User(Long id, String name, String lastName, String documentId, String phoneNumber, LocalDate birthDate, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
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

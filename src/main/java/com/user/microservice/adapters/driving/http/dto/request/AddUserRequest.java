package com.user.microservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AddUserRequest {

    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;

}

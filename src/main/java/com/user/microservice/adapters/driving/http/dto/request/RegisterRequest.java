package com.user.microservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
public class RegisterRequest {

    String name;
    String lastName;
    String documentId;
    String phoneNumber;
    LocalDate birthDate;
    String email;
    String password;

}

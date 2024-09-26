package com.user.microservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
public class RegisterResponse {

    String name;
    String lastName;
    String documentId;
    String phoneNumber;
    LocalDate birthDate;
    String email;
}

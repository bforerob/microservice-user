package com.user.microservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String lastName;
    private String documentId;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String encryptedPassword;
    private Integer role;

}

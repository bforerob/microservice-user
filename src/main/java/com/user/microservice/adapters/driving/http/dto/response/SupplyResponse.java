package com.user.microservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SupplyResponse {

    private final Long id;
    private final Long articleId;
    private final Integer quantity;

}

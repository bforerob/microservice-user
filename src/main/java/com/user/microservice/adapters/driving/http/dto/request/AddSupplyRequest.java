package com.user.microservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddSupplyRequest {

    private final Long articleId;
    private final Integer quantity;

}

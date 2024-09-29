package com.user.microservice.adapters.driving.http.dto.response;

import com.user.microservice.domain.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final Long quantity;
    private final BigDecimal price;
    private final Brand brand;
    private final List<CategoryResponse> categories;

}

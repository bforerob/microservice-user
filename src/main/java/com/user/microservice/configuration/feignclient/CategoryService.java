package com.user.microservice.configuration.feignclient;

import com.user.microservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.user.microservice.adapters.driving.http.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryFeignClient categoryFeignClient;

    public CategoryResponse addCategoryToStock(AddCategoryRequest request) {
        return categoryFeignClient.addCategory(request);
    }

}

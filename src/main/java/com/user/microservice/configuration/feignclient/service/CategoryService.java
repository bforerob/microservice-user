package com.user.microservice.configuration.feignclient.service;

import com.user.microservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.user.microservice.adapters.driving.http.dto.response.CategoryResponse;
import com.user.microservice.configuration.feignclient.client.CategoryFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryFeignClient categoryFeignClient;

    public CategoryResponse addCategory(AddCategoryRequest request) {
        return categoryFeignClient.addCategory(request);
    }

}

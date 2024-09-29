package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.user.microservice.adapters.driving.http.dto.response.CategoryResponse;
import com.user.microservice.configuration.feignclient.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody AddCategoryRequest request) {
        CategoryResponse categoryResponse = categoryService.addCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

}

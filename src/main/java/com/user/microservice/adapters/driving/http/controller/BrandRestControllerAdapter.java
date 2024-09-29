package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.user.microservice.adapters.driving.http.dto.response.BrandResponse;
import com.user.microservice.configuration.feignclient.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestControllerAdapter {

    private final BrandService brandService;

    @PostMapping("/")
    public ResponseEntity<BrandResponse> addCategory(@RequestBody AddBrandRequest request) {
        BrandResponse brandResponse = brandService.addBrand(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandResponse);
    }

}

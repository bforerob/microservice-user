package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.user.microservice.adapters.driving.http.dto.request.AddSupplyRequest;
import com.user.microservice.adapters.driving.http.dto.response.CategoryResponse;
import com.user.microservice.adapters.driving.http.dto.response.SupplyResponse;
import com.user.microservice.configuration.feignclient.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyRestControllerAdapter {

    private final SupplyService supplyService;

    @PostMapping("/")
    public ResponseEntity<SupplyResponse> addSupply(@RequestBody AddSupplyRequest request) {
        SupplyResponse supplyResponse = supplyService.addSupply(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyResponse);
    }

}

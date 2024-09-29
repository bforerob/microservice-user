package com.user.microservice.configuration.feignclient.service;

import com.user.microservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.user.microservice.adapters.driving.http.dto.response.BrandResponse;
import com.user.microservice.configuration.feignclient.client.BrandFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandFeignClient brandFeignClient;

    public BrandResponse addBrand(AddBrandRequest request) {
        return brandFeignClient.addBrand(request);
    }

}

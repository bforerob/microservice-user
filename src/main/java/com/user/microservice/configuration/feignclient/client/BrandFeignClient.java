package com.user.microservice.configuration.feignclient.client;

import com.user.microservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.user.microservice.adapters.driving.http.dto.response.BrandResponse;
import com.user.microservice.configuration.feignclient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-microservice-brand", url = "http://localhost:9090/brand", configuration = FeignClientConfig.class)
public interface BrandFeignClient {

    @PostMapping("/")
    BrandResponse addBrand(@RequestBody AddBrandRequest request);

}


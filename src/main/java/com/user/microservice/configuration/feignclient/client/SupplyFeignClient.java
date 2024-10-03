package com.user.microservice.configuration.feignclient.client;

import com.user.microservice.adapters.driving.http.dto.request.AddSupplyRequest;
import com.user.microservice.adapters.driving.http.dto.response.SupplyResponse;
import com.user.microservice.configuration.feignclient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transaction-microservice", url = "http://localhost:9091/supply", configuration = FeignClientConfig.class)
public interface SupplyFeignClient {

    @PostMapping("/")
    SupplyResponse addSupply(@RequestBody AddSupplyRequest request);

}

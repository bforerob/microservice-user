package com.user.microservice.configuration.feignclient.service;

import com.user.microservice.adapters.driving.http.dto.request.AddSupplyRequest;
import com.user.microservice.adapters.driving.http.dto.response.SupplyResponse;
import com.user.microservice.configuration.feignclient.client.SupplyFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyService {
    private final SupplyFeignClient supplyFeignClient;

    public SupplyResponse addSupply(AddSupplyRequest request) {
        return supplyFeignClient.addSupply(request);
    }

}

package com.user.microservice.configuration.feignclient;

import com.user.microservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.user.microservice.adapters.driving.http.dto.response.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-microservice", url = "http://localhost:9090/category", configuration = FeignClientConfig.class) // Ajusta la URL según la configuración de tu microservicio de stock
public interface CategoryFeignClient {

    @PostMapping("/")
    CategoryResponse addCategory(@RequestBody AddCategoryRequest request);

}


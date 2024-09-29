package com.user.microservice.configuration.feignclient.client;

import com.user.microservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.user.microservice.adapters.driving.http.dto.response.ArticleResponse;
import com.user.microservice.configuration.feignclient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-microservice-article", url = "http://localhost:9090/article", configuration = FeignClientConfig.class)
public interface ArticleFeignClient {

    @PostMapping("/")
    ArticleResponse addArticle(@RequestBody AddArticleRequest request);

}


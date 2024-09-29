package com.user.microservice.configuration.feignclient.service;

import com.user.microservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.user.microservice.adapters.driving.http.dto.response.ArticleResponse;
import com.user.microservice.configuration.feignclient.client.ArticleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleFeignClient articleFeignClient;

    public ArticleResponse addArticle(AddArticleRequest request) {
        return articleFeignClient.addArticle(request);
    }

}

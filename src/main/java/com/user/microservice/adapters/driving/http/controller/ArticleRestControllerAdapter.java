package com.user.microservice.adapters.driving.http.controller;

import com.user.microservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.user.microservice.adapters.driving.http.dto.response.ArticleResponse;
import com.user.microservice.configuration.feignclient.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestControllerAdapter {

    private final ArticleService articleService;

    @PostMapping("/")
    public ResponseEntity<ArticleResponse> addCategory(@RequestBody AddArticleRequest request) {
        ArticleResponse articleResponse = articleService.addArticle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleResponse);
    }

}

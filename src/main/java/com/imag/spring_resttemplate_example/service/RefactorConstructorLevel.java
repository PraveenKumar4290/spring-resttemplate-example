package com.imag.spring_resttemplate_example.service;

import com.imag.spring_resttemplate_example.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefactorConstructorLevel {
    @Value("${base.endPoint}")
    private String baseURL;

    private final RestTemplate restTemplateNew;

    public RefactorConstructorLevel(RestTemplate restTemplateNew) {
        this.restTemplateNew = restTemplateNew;
    }

    public PostResponse getPostById(Long id) {
        return restTemplateNew.getForObject(baseURL + "/posts/{id}", PostResponse.class, id);
    }

//    public String addPost(PostRequestDTO postRequestDTO, Long id) {
//        restTemplateNew.postForObject(baseURL + "/posts/{id}", postRequestDTO, Void.class, id);
//        return "Saved successfully...!";
//    }
}

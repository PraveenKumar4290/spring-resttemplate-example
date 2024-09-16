package com.imag.spring_resttemplate_example.service;

import com.imag.spring_resttemplate_example.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RefactorMethodLevel {

    @Value("${base.endPoint}")
    private String baseURL;

    public PostResponse getPostById(Long id) {
        final RestTemplate restTemplateNew = new RestTemplate();
        return restTemplateNew.getForObject(baseURL + "/posts/{id}", PostResponse.class, id);
    }
}

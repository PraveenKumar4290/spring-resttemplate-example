package com.imag.spring_resttemplate_example.service;


import com.imag.spring_resttemplate_example.exception.UserDefinedException;
import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    @Value("${base.endPoint}")
    private String baseURL;

    @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<?> getPostById(Long id) {
        try {
            ResponseEntity<PostResponse> post = restTemplate.getForEntity(baseURL + "/posts/{id}", PostResponse.class, id);
            if (post.getStatusCode() == HttpStatus.OK)
                return post;
            else
                throw new UserDefinedException("Something went wrong...!");
        } catch (RuntimeException ex) {
            throw new UserDefinedException(ex.getMessage());
        }

    }

    public ResponseEntity<?> addNewPost(PostRequestDTO postRequestDTO) {
        try {
            ResponseEntity<PostRequestDTO> postRequest = restTemplate.postForEntity(baseURL + "/posts", postRequestDTO, PostRequestDTO.class);
            if (postRequest.getStatusCode() == HttpStatus.OK || postRequest.getStatusCode() == HttpStatus.CREATED)
                return postRequest;
            else
                throw new UserDefinedException("Something went wrong...!");
        } catch (RuntimeException ex) {
            throw new UserDefinedException(ex.getMessage());
        }
    }
}


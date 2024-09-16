package com.imag.spring_resttemplate_example.service;


import com.imag.spring_resttemplate_example.exception.UserDefinedException;
import com.imag.spring_resttemplate_example.model.response.PostResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PostService {

    @Value("${base.endPoint}")
    private String baseURL;

    @Autowired
    private RestTemplate restTemplate;

    public PostResponse getPostById(Long id) {
        try {
            return restTemplate.getForObject(baseURL + "/posts/{id}", PostResponse.class, id);
        } catch (RuntimeException ex) {
            log.error("Exception: {}", ex.getMessage());
            throw new UserDefinedException(ex.getMessage());
        }
    }

//    public ResponseEntity<?> addNewPost(PostRequestDTO postRequestDTO) {
//        try {
//            ResponseEntity<PostResponse> postResponse = restTemplate.postForEntity(baseURL + "/posts", postRequestDTO, PostResponse.class);
//            if (postResponse.getStatusCode() == HttpStatus.OK || postResponse.getStatusCode() == HttpStatus.CREATED) {
//                log.info("Data : {}", postResponse.getBody());
//                return ResponseEntity.ok(postResponse.getBody());
////                return postResponse;
//            } else
//                throw new UserDefinedException("Something went wrong...!");
//        } catch (RuntimeException ex) {
//            log.error("Exception : {}", ex.getMessage());
//            throw new UserDefinedException(ex.getMessage());
//        }
//    }
}


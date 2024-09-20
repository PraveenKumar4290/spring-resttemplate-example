package com.imag.spring_resttemplate_example.service;

import com.imag.spring_resttemplate_example.exception.UserDefinedException;
import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.model.response.PostResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RefactorConstructorLevel {
    @Value("${base.endPoint}")
    private String baseURL;

    private final RestTemplate restTemplate;

    public RefactorConstructorLevel(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PostResponse getPostByIdUsingGetForObject(Long id) {
        try {
            return restTemplate.getForObject(baseURL + "/posts/{id}", PostResponse.class, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException("Something went wrong");
        }

    }

    public PostResponse[] getPostsUsingGetForObject() {
        try {
            return restTemplate.getForObject(baseURL + "/posts", PostResponse[].class);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse addPostUsingPostForObject(PostRequestDTO postRequestDTO) {
        try {
            return restTemplate.postForObject(baseURL + "/posts", postRequestDTO, PostResponse.class);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse addPostByIdUsingPostForObject(PostRequestDTO postRequestDTO, Long id) {
        try {
            return restTemplate.postForObject(baseURL + "/posts/{id}", postRequestDTO, PostResponse.class, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse getPostByIdUsingGetForEntity(Long id) {
        try {
            return restTemplate.getForEntity(baseURL + "/posts/{id}", PostResponse.class, id).getBody();
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public ResponseEntity<PostResponse[]> getPostsUsingGetForEntity() {

        try {
            return restTemplate.getForEntity(baseURL + "/posts", PostResponse[].class);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse addPostUsingPostForEntity(PostRequestDTO postRequestDTO) {

        try {
            return restTemplate.postForEntity(baseURL + "/posts", postRequestDTO, PostResponse.class).getBody();
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public ResponseEntity<PostResponse> addPostByIdUsingPostForEntity(PostRequestDTO postRequestDTO, Long id) {
        try {
            return restTemplate.postForEntity(baseURL + "/posts/{id}", postRequestDTO, PostResponse.class, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse addPostUsingPostExchange(PostRequestDTO postRequestDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(postRequestDTO, headers);
            return restTemplate.exchange(baseURL + "/posts", HttpMethod.POST, entity, PostResponse.class).getBody();
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public ResponseEntity<PostResponse> addPostByIdUsingPostExchange(Long id, PostRequestDTO postRequestDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(postRequestDTO, headers);
            return restTemplate.exchange(baseURL + "/posts/{id}", HttpMethod.POST, entity, PostResponse.class, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse getPostByIdUsingGetExchange(Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            return restTemplate.exchange(baseURL + "/posts/{id}", HttpMethod.GET, entity, PostResponse.class, id).getBody();
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public ResponseEntity<PostResponse[]> getPostsUsingGetExchange() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            return restTemplate.exchange(baseURL + "/posts", HttpMethod.GET, entity, PostResponse[].class);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public PostResponse updatePostUsingPutExchange(Long id, PostRequestDTO postRequestDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>(postRequestDTO, headers);
            return restTemplate.exchange(baseURL + "/posts/{id}", HttpMethod.PUT, entity, PostResponse.class, id).getBody();
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }

    public ResponseEntity<PostResponse[]> getPostsUsingGetExchangeOfURI() throws URISyntaxException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            return restTemplate.exchange(new URI(baseURL + "/posts"), HttpMethod.GET, entity, PostResponse[].class);
        } catch (RuntimeException e) {
            throw new UserDefinedException("something went wrong");
        }
    }


//    public void hello(PostRequestDTO postRequestDTO, Long id) {
//        ResponseEntity<String> exchange3 = restTemplate.exchange(baseURL + "/posts/{id}", HttpMethod.DELETE, new HttpEntity<>(new HashMap<>()), String.class,id);
//        ResponseEntity<String> exchange4 = restTemplate.exchange(baseURL + "/posts/{id}", HttpMethod.DELETE, new HttpEntity<>(new HashMap<>()), String.class);
//    }

}


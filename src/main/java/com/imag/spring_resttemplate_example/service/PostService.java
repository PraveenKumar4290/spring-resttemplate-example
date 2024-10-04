package com.imag.spring_resttemplate_example.service;


import com.imag.spring_resttemplate_example.exception.UserDefinedException;
import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.model.response.PostResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class PostService {

    @Value("${base.endPoint}")
    private String baseURL;

    private String authURL = "http://localhost:8084/auth";

    private static final String API_KEY = "api-key";

    @Autowired
    private RestTemplate newRestTemplate;

    public PostResponse getPostById(Long id) {
        try {
            return newRestTemplate.getForObject(baseURL + "/posts/{id}", PostResponse.class, id);
        } catch (RuntimeException ex) {
            log.error("Exception: {}", ex.getMessage());
            throw new UserDefinedException(ex.getMessage());
        }
    }

    public ResponseEntity<?> addNewPost(PostRequestDTO postRequestDTO) {
        try {
            ResponseEntity<PostResponse> postResponse = newRestTemplate.postForEntity(baseURL + "/posts", postRequestDTO, PostResponse.class);
            if (postResponse.getStatusCode() == HttpStatus.OK || postResponse.getStatusCode() == HttpStatus.CREATED) {
                log.info("Data : {}", postResponse.getBody());
                return ResponseEntity.ok(postResponse.getBody());
//                return postResponse;
            } else
                throw new UserDefinedException("Something went wrong...!");
        } catch (RuntimeException ex) {
            log.error("Exception : {}", ex.getMessage());
            throw new UserDefinedException(ex.getMessage());
        }
    }

    protected ResponseEntity<String> restTemplate(Long id) throws Exception {
        RequestEntity<?> request =
                RequestEntity.post(new URI("http://localhost:8080/api"))
                        .headers(headers -> headers.setContentType(MediaType.ALL))
                        .headers(header -> header.setBearerAuth("yudvwduuwdbwiydwd"))
                        .header("ApplicationConstants.ORGANIZATION_HEADER", String.valueOf(1))
                        .header(API_KEY, "carrierRatesClientConfiguration.getApiKey()")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(null);
        return newRestTemplate.exchange("http://localhost:8080/api", HttpMethod.POST, request, String.class);
    }


    public void sendRequest() throws Exception {
        String url = "https://example.com";
        String accessToken = "someAccessToken";
        String organizationGuid = "someOrg";
        String apiKey = "someApiKey";
        Object carrierRatesRequest = new Object();
        RequestEntity<?> request =
                RequestEntity.post(new URI(url))
                        .headers(header -> {
                            header.setBearerAuth("gyufueygwdytwugctyc");
                            header.setContentType(MediaType.ALL);
                            header.set("hiiii", "helllloooo");
                        })
                        .header("Authorization", "Bearer " + accessToken)
                        .header("X-Organization-Guid", organizationGuid)
                        .header("API-Key", apiKey)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(carrierRatesRequest);
        newRestTemplate.exchange(new URI(url), HttpMethod.POST, request, Object.class);
    }

    public void test1() throws Exception {
        String url = "https://example.com";
        String accessToken = "someAccessToken";
        String organizationGuid = "someOrg";
        String apiKey = "someApiKey";
        Object carrierRatesRequest = new Object();
        RequestEntity<?> request =
                RequestEntity.post(new URI(url))
                        .headers(header -> {
                            header.setBearerAuth("gyufueygwdytwugctyc");
                            header.setContentType(MediaType.ALL);
                            header.set("hiiii", "helllloooo");
                        })
                        .header("Authorization", "Bearer " + accessToken)
                        .header("X-Organization-Guid", organizationGuid)
                        .header("API-Key", apiKey)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(carrierRatesRequest);
        ParameterizedTypeReference<Object> parameterizedTypeReference = new ParameterizedTypeReference<Object>() {
        };
        newRestTemplate.exchange(request, parameterizedTypeReference);
    }

    public void test2() throws Exception {
        String url = "https://example.com";
        String accessToken = "someAccessToken";
        String organizationGuid = "someOrg";
        String apiKey = "someApiKey";
        RequestEntity<?> request =
                RequestEntity.get(new URI(url))
                        .headers(header -> {
                            header.setBearerAuth("gyufueygwdytwugctyc");
                            header.setContentType(MediaType.ALL);
                            header.set("hiiii", "helllloooo");
                        })
                        .header("Authorization", "Bearer " + accessToken)
                        .header("X-Organization-Guid", organizationGuid)
                        .header("API-Key", apiKey)
                        .accept(MediaType.APPLICATION_JSON)
                        .build();
        ParameterizedTypeReference<Object> parameterizedTypeReference = new ParameterizedTypeReference<Object>() {
        };
        newRestTemplate.exchange(request, parameterizedTypeReference);
    }

    public void test3() throws Exception {
        String url = "https://example.com";
        String accessToken = "someAccessToken";
        String organizationGuid = "someOrg";
        String apiKey = "someApiKey";
        Object carrierRatesRequest = new Object();
        RequestEntity<?> request =
                RequestEntity.put(new URI(url))
                        .headers(header -> {
                            header.setBearerAuth("gyufueygwdytwugctyc");
                            header.setContentType(MediaType.ALL);
                            header.set("hiiii", "helllloooo");
                        })
                        .header("Authorization", "Bearer " + accessToken)
                        .header("X-Organization-Guid", organizationGuid)
                        .header("API-Key", apiKey)
                        .accept(MediaType.APPLICATION_JSON)
                        .body(carrierRatesRequest);
        ParameterizedTypeReference<Object> parameterizedTypeReference = new ParameterizedTypeReference<Object>() {
        };
        newRestTemplate.exchange(request, parameterizedTypeReference);
    }
}


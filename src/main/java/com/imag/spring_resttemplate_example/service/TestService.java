package com.imag.spring_resttemplate_example.service;

import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.model.response.PostResponse;

public class TestService {

    private final PostResponse postResponse;
    private final PostRequestDTO postRequestDTO;
    public TestService(PostResponse postResponse, PostRequestDTO postRequestDTO){
        this.postResponse=postResponse;
        this.postRequestDTO=postRequestDTO;
    }


    public void testFunction(){
        postResponse.getTitle();
        postRequestDTO.getTitle();
    }
}

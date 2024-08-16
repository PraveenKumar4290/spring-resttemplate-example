package com.imag.spring_resttemplate_example.controller;

import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<?> addNewPost(@RequestBody PostRequestDTO postRequestDTO) {
        return postService.addNewPost(postRequestDTO);
    }
}

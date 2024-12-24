package com.imag.spring_resttemplate_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imag.spring_resttemplate_example.service.PostService;
import com.imag.spring_resttemplate_example.service.RefactorConstructorLevel;
import com.imag.spring_resttemplate_example.service.RefactorMethodLevel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Posts Management", description = "Alternative APIs for managing posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private RefactorConstructorLevel constructorLevel;

    @Autowired
    private RefactorMethodLevel methodLevel;

    @Operation(summary = "Get post by ID", description = "Retrieves a post using the post service")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPost(
            @Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get post by ID using method level", description = "Retrieves a post using method level implementation")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/get/method/{id}")
    public ResponseEntity<?> getPostByMethodLevel(
            @Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        return new ResponseEntity<>(methodLevel.getPostById(id), HttpStatus.OK);
    }

//    @GetMapping("/get/constructor/{id}")
//    public ResponseEntity<?> getPostByConstructorLevel(@PathVariable Long id) {
//        return new ResponseEntity<>(constructorLevel.getPostById(id), HttpStatus.OK);
//    }

//    @PostMapping("/post")
//    public ResponseEntity<?> addNewPost(@RequestBody PostRequestDTO postRequestDTO) {
//        return postService.addNewPost(postRequestDTO);
//    }

}

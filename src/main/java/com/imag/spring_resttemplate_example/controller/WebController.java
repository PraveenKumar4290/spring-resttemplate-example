package com.imag.spring_resttemplate_example.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imag.spring_resttemplate_example.exception.UserDefinedException;
import com.imag.spring_resttemplate_example.model.request.PostRequestDTO;
import com.imag.spring_resttemplate_example.model.response.PostResponse;
import com.imag.spring_resttemplate_example.service.RefactorConstructorLevel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Posts API", description = "REST APIs for managing posts using different RestTemplate methods")
public class WebController {

    @Autowired
    private RefactorConstructorLevel constructorLevel;

    @Operation(summary = "Get post by ID using getForObject", description = "Retrieves a post using RestTemplate's getForObject method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-object/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetForObject(
            @Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetForObject(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get all posts using getForObject", description = "Retrieves all posts using RestTemplate's getForObject method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved posts"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-object")
    public ResponseEntity<?> getPostsUsingGetForObject() {
        try {
            return ResponseEntity.ok(constructorLevel.getPostsUsingGetForObject());
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post using postForObject", description = "Creates a new post using RestTemplate's postForObject method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-object")
    public ResponseEntity<?> addPostUsingPostForObject(
            @Parameter(description = "Post request body") @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostForObject(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post by ID using postForObject", description = "Creates a new post by ID using RestTemplate's postForObject method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-object/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostForObject(@RequestBody PostRequestDTO postRequestDTO, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostByIdUsingPostForObject(postRequestDTO, id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get post by ID using getForEntity", description = "Retrieves a post using RestTemplate's getForEntity method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-entity/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetForEntity(
            @Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetForEntity(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get all posts using getForEntity", description = "Retrieves all posts using RestTemplate's getForEntity method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved posts"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-entity")
    public ResponseEntity<PostResponse[]> getPostsUsingGetForEntity() {
        try {
            return constructorLevel.getPostsUsingGetForEntity();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post using postForEntity", description = "Creates a new post using RestTemplate's postForEntity method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-entity")
    public ResponseEntity<PostResponse> addPostUsingPostForEntity(
            @Parameter(description = "Post request body") @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostForEntity(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post by ID using postForEntity", description = "Creates a new post by ID using RestTemplate's postForEntity method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-entity/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostForEntity(@RequestBody PostRequestDTO postRequestDTO, @PathVariable Long id) {
        try {
            return constructorLevel.addPostByIdUsingPostForEntity(postRequestDTO, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post using postExchange", description = "Creates a new post using RestTemplate's postExchange method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-exchange")
    public ResponseEntity<PostResponse> addPostUsingPostExchange(
            @Parameter(description = "Post request body") @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostExchange(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Create post by ID using postExchange", description = "Creates a new post by ID using RestTemplate's postExchange method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created post"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/posts/post-exchange/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostExchange(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return constructorLevel.addPostByIdUsingPostExchange(id, postRequestDTO);
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get post by ID using getExchange", description = "Retrieves a post using RestTemplate's getExchange method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-exchange/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetExchange(
            @Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetExchange(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get all posts using getExchange", description = "Retrieves all posts using RestTemplate's getExchange method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved posts"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-exchange")
    public ResponseEntity<PostResponse[]> getPostsUsingGetExchange() {
        try {
            return constructorLevel.getPostsUsingGetExchange();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Update post using putExchange", description = "Updates an existing post using RestTemplate's putExchange method")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Post updated successfully"),
        @ApiResponse(responseCode = "404", description = "Post not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/posts/put-exchange/{id}")
    public ResponseEntity<PostResponse> updatePostUsingPutExchange(
            @Parameter(description = "ID of the post to update") @PathVariable Long id,
            @Parameter(description = "Updated post data") @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.updatePostUsingPutExchange(id, postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @Operation(summary = "Get posts using Exchange with URI", description = "Retrieves all posts using RestTemplate's getExchange method with URI")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved posts"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/posts/get-change-uri")
    public ResponseEntity<PostResponse[]> getPostsUsingGetExchangeOfURI() throws URISyntaxException {
        try {
            return constructorLevel.getPostsUsingGetExchangeOfURI();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }
}

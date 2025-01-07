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


@RestController
public class WebController {

    @Autowired
    private RefactorConstructorLevel constructorLevel;

    @GetMapping("/posts/get-object/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetForObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetForObject(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @GetMapping("/posts/get-object")
    public ResponseEntity<?> getPostsUsingGetForObject() {
        try {
            return ResponseEntity.ok(constructorLevel.getPostsUsingGetForObject());
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @PostMapping("/posts/post-object")
    public ResponseEntity<?> addPostUsingPostForObject(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostForObject(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @PostMapping("/posts/post-object/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostForObject(@RequestBody PostRequestDTO postRequestDTO, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostByIdUsingPostForObject(postRequestDTO, id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @GetMapping("/posts/get-entity/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetForEntity(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetForEntity(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @GetMapping("/posts/get-entity")
    public ResponseEntity<PostResponse[]> getPostsUsingGetForEntity() {
        try {
            return constructorLevel.getPostsUsingGetForEntity();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @PostMapping("/posts/post-entity")
    public ResponseEntity<PostResponse> addPostUsingPostForEntity(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostForEntity(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @PostMapping("/posts/post-entity/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostForEntity(@RequestBody PostRequestDTO postRequestDTO, @PathVariable Long id) {
        try {
            return constructorLevel.addPostByIdUsingPostForEntity(postRequestDTO, id);
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @PostMapping("/posts/post-exchange")
    public ResponseEntity<PostResponse> addPostUsingPostExchange(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.addPostUsingPostExchange(postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }


    @PostMapping("/posts/post-exchange/{id}")
    public ResponseEntity<PostResponse> addPostByIdUsingPostExchange(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO) {
        try {
            return constructorLevel.addPostByIdUsingPostExchange(id, postRequestDTO);
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

   
    @GetMapping("/posts/get-exchange/{id}")
    public ResponseEntity<PostResponse> getPostByIdUsingGetExchange( @PathVariable Long id) {
        try {
            return ResponseEntity.ok(constructorLevel.getPostByIdUsingGetExchange(id));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

   
    @GetMapping("/posts/get-exchange")
    public ResponseEntity<PostResponse[]> getPostsUsingGetExchange() {
        try {
            return constructorLevel.getPostsUsingGetExchange();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    
    @PutMapping("/posts/put-exchange/{id}")
    public ResponseEntity<PostResponse> updatePostUsingPutExchange(@PathVariable Long id,@RequestBody PostRequestDTO postRequestDTO) {
        try {
            return ResponseEntity.ok(constructorLevel.updatePostUsingPutExchange(id, postRequestDTO));
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }

    @GetMapping("/posts/get-change-uri")
    public ResponseEntity<PostResponse[]> getPostsUsingGetExchangeOfURI() throws URISyntaxException {
        try {
            return constructorLevel.getPostsUsingGetExchangeOfURI();
        } catch (RuntimeException e) {
            throw new UserDefinedException(e.getMessage());
        }
    }
}

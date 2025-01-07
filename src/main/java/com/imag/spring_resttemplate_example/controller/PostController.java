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



@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private RefactorConstructorLevel constructorLevel;

    @Autowired
    private RefactorMethodLevel methodLevel;

 
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPost( @PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/get/method/{id}")
    public ResponseEntity<?> getPostByMethodLevel(@PathVariable Long id) {
        return new ResponseEntity<>(methodLevel.getPostById(id), HttpStatus.OK);
    }

}

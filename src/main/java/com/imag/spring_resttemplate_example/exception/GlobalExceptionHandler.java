package com.imag.spring_resttemplate_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<?> userDefinedException(UserDefinedException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("error", HttpStatus.BAD_REQUEST);
        body.put("time", Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}

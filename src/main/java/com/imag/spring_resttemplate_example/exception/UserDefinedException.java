package com.imag.spring_resttemplate_example.exception;

public class UserDefinedException extends RuntimeException{

    public UserDefinedException(String msg){
        super(msg);
    }
}

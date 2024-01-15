package com.chuwa.redbook.services.impl;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "ResourceNotFoundException")
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("ResourceNotFoundException");
    }


}

package com.chuwa.BankStatement.controller;

import com.chuwa.BankStatement.payload.UserDto;
import com.chuwa.BankStatement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class PostUser {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> postUser(@Valid @RequestBody UserDto userDto){
        UserDto userResponse = userService.postUser(userDto);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}

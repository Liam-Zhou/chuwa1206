package com.chuwa.learn.statement.controller;

import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto res = this.userService.createUser(userDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}

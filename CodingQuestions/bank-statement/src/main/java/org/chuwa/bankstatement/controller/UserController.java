package org.chuwa.bankstatement.controller;

import jakarta.validation.Valid;
import org.chuwa.bankstatement.payload.UserDto;
import org.chuwa.bankstatement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> postUser(@Valid @RequestBody UserDto userDto) {
        UserDto user = userService.createUserProfile(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

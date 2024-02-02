package org.chuwa.bankstatement.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.chuwa.bankstatement.payload.UserDto;
import org.chuwa.bankstatement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<UserDto> postUser(@Valid @RequestBody UserDto userDto) {
        UserDto user = userService.createUserProfile(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto, HttpServletResponse response) {
        // set the user ID and preference cookies
        Cookie userIdCookie = new Cookie("userName", userDto.getName());
        userIdCookie.setMaxAge(240); // expires in 4min
        response.addCookie(userIdCookie);
        Cookie preferenceCookie = new Cookie("email", userDto.getEmail());
        preferenceCookie.setMaxAge(240);
        response.addCookie(preferenceCookie);
        logger.info(response.toString());
        return "Logged in, cookie have been set";
    }
}

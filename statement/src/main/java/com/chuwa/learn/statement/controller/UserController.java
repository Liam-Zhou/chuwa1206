package com.chuwa.learn.statement.controller;

import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto,  HttpServletResponse response) {
        UserDto res = this.userService.createUser(userDto);
        Cookie cookie = new Cookie("user_token", res.getName());
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/cookie_test")
    public  String cookieTest(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("Cookie Name: {}, Cookie Value: {}", cookie.getName(), cookie.getValue());
            }
        } else {
            log.info("No cookies found in the request.");
        }

        return "showCookies";
    }
}

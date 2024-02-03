package com.chuwa.statement.controller;

import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.UserDto;
import com.chuwa.statement.service.inter.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chuwa/statement/user")
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(
            @PathVariable long id,
            HttpServletResponse response,
            HttpServletRequest request
            ){
         UserDto userDto=userService.findUserById(id);
         log.info(request.getPathInfo());
         log.info(request.getMethod());
        Optional.ofNullable(request.getCookies()).ifPresent(
                cookies-> Arrays.stream(cookies).forEach(
                        cookie-> logCookieInfo(cookie)
                )
        );
        Cookie cookie=new Cookie("MyChuwaStatementCookie", "ccchuwa");
        cookie.setMaxAge(10);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.addHeader("Set-Cookie" , "UserId=" + String.valueOf(id) + "; Max-Age=10; Path=/");

        return  ResponseEntity.ok(userDto);
    }

    public void logCookieInfo(Cookie cookie) {
        log.info("Cookie Name: {}, Value: {}, Domain: {}, Path: {}, Max Age: {}, Secure: {}, HttpOnly: {}",
                cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(),
                cookie.getMaxAge(), cookie.getSecure(), cookie.isHttpOnly());
        log.info("-------------");
    }


}

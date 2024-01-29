package com.example.bank.statement.controller;

import com.example.bank.statement.payload.UserProfileDto;
import com.example.bank.statement.service.UserProfileService;
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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user_profile")
@Slf4j
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
        return new ResponseEntity<>(this.userProfileService.createUserProfile(userProfileDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserProfileById(@PathVariable(name = "id") long id, HttpServletResponse response, HttpServletRequest request,
                                                             @CookieValue(value = "userProfileId", defaultValue = "") String cookieValue) {
        UserProfileDto userProfileDto = this.userProfileService.getUserProfileById(id);
        //log request
        log.info(request.getPathInfo());
        log.info(request.getMethod());
        Optional.ofNullable(request.getCookies()).ifPresent(cookies -> Arrays.stream(cookies).forEach(cookie -> logCookieDetails(cookie)));
        //try @CookieValue
        log.info("cookieValue is: " + cookieValue);
        //add one cookie
        Cookie cookie = new Cookie("myUniqueCookieKey", "message");
        cookie.setMaxAge(10);
        cookie.setPath("/");
        response.addCookie(cookie);
        //add header
        response.addHeader("Set-Cookie", "userProfileId=" + String.valueOf(id) + "; Max-Age=3600; Path=/");

        return new ResponseEntity<>(userProfileDto, HttpStatus.OK);
    }

    private void logCookieDetails(Cookie cookie) {
        log.info("Cookie Name: {}, Value: {}, Domain: {}, Path: {}, Max Age: {}, Secure: {}, HttpOnly: {}",
                cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(),
                cookie.getMaxAge(), cookie.getSecure(), cookie.isHttpOnly());
        log.info("-------------");
    }

}

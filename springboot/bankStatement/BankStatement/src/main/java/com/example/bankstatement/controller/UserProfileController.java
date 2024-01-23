package com.example.bankstatement.controller;

import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/user-profiles")
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfileDto response = userProfileService.createUserProfile(userProfileDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}

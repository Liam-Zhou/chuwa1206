package com.example.bank.statement.controller;

import com.example.bank.statement.payload.UserProfileDto;
import com.example.bank.statement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user_profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        return new ResponseEntity<>(this.userProfileService.createUserProfile(userProfileDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserProfileById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(this.userProfileService.getUserProfileById(id), HttpStatus.OK);
    }
}

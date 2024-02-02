package com.example.bankproject.controller;

import com.example.bankproject.payload.UserProfileDto;
import com.example.bankproject.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> addUser(@Valid @RequestBody UserProfileDto userProfileDto) {
        return new ResponseEntity<>(userProfileService.addUser(userProfileDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAll() {
        return new ResponseEntity<>(userProfileService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userProfileService.getById(id), HttpStatus.CREATED);
    }
}

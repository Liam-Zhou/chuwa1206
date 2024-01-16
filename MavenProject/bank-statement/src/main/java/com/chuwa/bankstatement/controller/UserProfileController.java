package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.UserProfileDto;
import com.chuwa.bankstatement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorui
 */
@RestController
@RequestMapping("api/v1/user-profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        UserProfileDto response = this.userProfileService.createUserProfile(userProfileDto);

        return ResponseEntity.ok(response);
    }
}

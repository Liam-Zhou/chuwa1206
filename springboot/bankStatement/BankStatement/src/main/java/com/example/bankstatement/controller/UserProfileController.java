package com.example.bankstatement.controller;

import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.UserProfileService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @PostMapping("/user-profiles")
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfileDto response = userProfileService.createUserProfile(userProfileDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * for admin
     * @return
     */
    @GetMapping("/user-profiles")
    public ResponseEntity<List<UserProfileDto>> getAllUserProfile(){
        return new ResponseEntity<>(userProfileService.getAllUserProfile(),HttpStatus.OK);
    }

//    @GetMapping("/user-profiles/{userId}")
//    public ResponseEntity<UserProfileDto>

    @GetMapping("/user-profiles/{userId}/accounts")
    public ResponseEntity<List<AccountDtoWithoutUserProfile>> getAllAccountsByUserId(
            @PathVariable(value = "userId") Long userId,
    HttpServletRequest request){
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                logger.info("Cookie Name: " + cookie.getName() + ", Cookie Value: " + cookie.getValue());
            }
        } else {
            logger.error("No cookies found");
        }
        return new ResponseEntity<>(userProfileService.getAllAccountsByUserId(userId),HttpStatus.OK);
    }


}

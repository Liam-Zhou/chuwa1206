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
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        UserProfileDto response = userProfileService.createUserProfile(userProfileDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * for admin
     *
     * @return
     */
    @GetMapping("/user-profiles")
    public ResponseEntity<List<UserProfileDto>> getAllUserProfile() {
        return new ResponseEntity<>(userProfileService.getAllUserProfile(), HttpStatus.OK);
    }

    @GetMapping("/user-profiles/{userId}")
    public ResponseEntity<UserProfileDto> getUserProfileByUserId(@PathVariable(value = "userId") Long userId) {
        return new ResponseEntity<>(userProfileService.getUserProfileByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/user-profiles/{userId}/accounts")
    public ResponseEntity<List<AccountDtoWithoutUserProfile>> getAllAccountsByUserId(
            @PathVariable(value = "userId") Long userId) {
        return new ResponseEntity<>(userProfileService.getAllAccountsByUserId(userId), HttpStatus.OK);
    }

    /**
     * Header with Cookie
     *
     * @param userId
     * @param
     * @return
     */
//    @GetMapping("/user-profiles/{userId}/accounts")
//    public ResponseEntity<List<AccountDtoWithoutUserProfile>> getAllAccountsByUserId(
//            @PathVariable(value = "userId") Long userId,
//    HttpServletRequest request){
//        if (request.getCookies() != null) {
//            for (Cookie cookie : request.getCookies()) {
//                logger.info("Cookie Name: " + cookie.getName() + ", Cookie Value: " + cookie.getValue());
//            }
//        } else {
//            logger.error("No cookies found");
//        }
//        return new ResponseEntity<>(userProfileService.getAllAccountsByUserId(userId),HttpStatus.OK);
//    }

    @PutMapping("/user-profiles/{userId}")
    public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable(value = "userId") Long userId,
                                                            @RequestBody UserProfileDto userProfileDto){
        UserProfileDto updatedUserProfileDto= userProfileService.updateUserProfile(userId, userProfileDto);
        return new ResponseEntity<>(updatedUserProfileDto, HttpStatusCode.valueOf(222));
    }

    @DeleteMapping ("/user-profiles/{userId}")
    public ResponseEntity<String> deleteUserProfile(@PathVariable(value = "userId") Long userId) {
        userProfileService.deleteUserProfile(userId);
        return new ResponseEntity<>("The user profile deleted successfully.", HttpStatusCode.valueOf(200));
    }

    /**
     * for test: if JPARepo.delete() return entity: no JPARepo.delete() return void.
     * @param userId
     * @return
     */
//    @DeleteMapping ("/user-profiles/{userId}/delete-tst")
//    public ResponseEntity<UserProfileDto> deleteUserProfile1(@PathVariable(value = "userId") Long userId) {
//        UserProfileDto response = userProfileService.deleteUserProfile1(userId);
//        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
//    }


}


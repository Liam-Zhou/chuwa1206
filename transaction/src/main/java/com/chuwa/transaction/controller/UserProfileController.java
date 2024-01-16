package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.UserProfileService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserProfileController {
    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        UserProfileDto user = this.userProfileService.createUserProfile(userProfileDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAllUserProfiles() {
        List<UserProfileDto> res = this.userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfilesById(@PathVariable(name = "id") long id, @RequestBody UserProfileDto userProfileDto) {
        UserProfileDto updated = this.userProfileService.updateUserProfile(userProfileDto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserProfileById(@PathVariable(name="id") long id) {
        this.userProfileService.deleteUserProfileById(id);
        return new ResponseEntity<>("Delete successfully", HttpStatusCode.valueOf(200));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserProfileDto> getUserprofileByAccountId(@PathVariable(name="id") long id) {
//        return ResponseEntity.ok(this.userProfileService.getUserProfileByAccountId(id)) ;
//    }
}

package com.example.bankstatement.service;

import com.example.bankstatement.payload.UserProfileDto;

/**
 * @author Alex D.
 */
public interface UserProfileService {
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);
}

package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.UserProfileDto;

/**
 * @author xiaorui
 */
public interface UserProfileService {
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    UserProfileDto getUserProfileById(Long id);
}

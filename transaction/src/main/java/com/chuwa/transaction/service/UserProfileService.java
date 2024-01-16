package com.chuwa.transaction.service;

import com.chuwa.transaction.payload.UserProfileDto;

import java.util.List;

public interface UserProfileService {
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);
    UserProfileDto updateUserProfile(UserProfileDto userProfileDto, long id);
    void deleteUserProfileById(long id);

    List<UserProfileDto> getAllUserProfiles();
//    UserProfileDto getUserProfileByAccountId(long accountId);
    UserProfileDto getUserProfileById(long userId);
}

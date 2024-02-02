package com.example.bank.statement.service;

import com.example.bank.statement.payload.UserProfileDto;

public interface UserProfileService {
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    UserProfileDto getUserProfileById(long id);
}

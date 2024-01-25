package com.example.bankstatement.service;

import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.UserProfileDto;

import java.util.List;

/**
 * @author Alex D.
 */
public interface UserProfileService {
    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    List<UserProfileDto> getAllUserProfile();

    List<AccountDtoWithoutUserProfile> getAllAccountsByUserId(Long userId);
}

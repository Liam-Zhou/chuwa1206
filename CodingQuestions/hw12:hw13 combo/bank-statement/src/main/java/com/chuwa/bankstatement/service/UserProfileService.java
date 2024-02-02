package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.entity.UserProfile;
import com.chuwa.bankstatement.payload.UserProfileDto;

import java.util.List;

public interface UserProfileService {


    UserProfileDto addUser(UserProfileDto userProfileDto);

    List<UserProfileDto> getAll();

    UserProfileDto getById(Long id);

    List<UserProfile> findByIdBetween(Long startId, Long endId);


}

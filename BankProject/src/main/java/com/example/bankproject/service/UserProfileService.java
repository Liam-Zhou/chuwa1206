package com.example.bankproject.service;

import com.example.bankproject.entity.UserProfile;
import com.example.bankproject.payload.UserProfileDto;

import java.util.List;

public interface UserProfileService {
    UserProfileDto addUser(UserProfileDto userProfileDto);

    List<UserProfileDto> getAll();

    UserProfileDto getById(Long id);

    List<UserProfile> findByIdBetween(Long startId, Long endId);

}

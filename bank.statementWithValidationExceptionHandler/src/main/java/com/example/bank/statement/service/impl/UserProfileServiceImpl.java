package com.example.bank.statement.service.impl;

import com.example.bank.statement.dao.UserProfileRepository;
import com.example.bank.statement.entity.UserProfile;
import com.example.bank.statement.exception.ResourceNotFoundException;
import com.example.bank.statement.payload.UserProfileDto;
import com.example.bank.statement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        UserProfile toBeSaved = mapToEntity(userProfileDto);

        UserProfile saved = this.userProfileRepository.save(toBeSaved);

        return mapToDto(saved);
    }

    @Override
    public UserProfileDto getUserProfileById(long id) {
        UserProfile userProfile = this.userProfileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));

        return mapToDto(userProfile);
    }

    private UserProfileDto mapToDto(UserProfile saved) {
        UserProfileDto userProfileDto = new UserProfileDto();

        userProfileDto.setId(saved.getId());
        userProfileDto.setName(saved.getName());
        userProfileDto.setPhone(saved.getPhone());
        userProfileDto.setAddress(saved.getAddress());
        userProfileDto.setEmail(saved.getEmail());

        return userProfileDto;
    }

    private UserProfile mapToEntity(UserProfileDto userProfileDto) {
        UserProfile userProfile = new UserProfile();

        userProfile.setName(userProfileDto.getName());
        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setPhone(userProfileDto.getPhone());
        userProfile.setEmail(userProfileDto.getEmail());

        return userProfile;
    }
}

package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.dao.UserProfileRepository;
import com.chuwa.bankstatement.entity.UserProfile;
import com.chuwa.bankstatement.exception.ResourceNotFoundException;
import com.chuwa.bankstatement.payload.UserProfileDto;
import com.chuwa.bankstatement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaorui
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        // Convert DTO to Entity
        UserProfile userProfile = convertToEntity(userProfileDto);

        // Save the user profile entity
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);

        // Convert the saved entity back to DTO
        return convertToDto(savedUserProfile);
    }

    @Override
    public UserProfileDto getUserProfileById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));

        return convertToDto(userProfile);
    }

    private UserProfile convertToEntity(UserProfileDto dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(dto.getId());
        userProfile.setName(dto.getName());
        userProfile.setAddress(dto.getAddress());
        userProfile.setPhone(dto.getPhone());
        userProfile.setEmail(dto.getEmail());
        return userProfile;
    }

    private UserProfileDto convertToDto(UserProfile entity) {
        UserProfileDto dto = new UserProfileDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        return dto;
    }

}

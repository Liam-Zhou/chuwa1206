package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    /**
     * use modelMapper instead of DtoToEntity or EntityToDto;
     * @return
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        UserProfile userProfile = modelMapper.map(userProfileDto, UserProfile.class);
        UserProfile savedUserProfile = userProfileRepo.save(userProfile);

        return modelMapper.map(savedUserProfile, UserProfileDto.class);
    }
}

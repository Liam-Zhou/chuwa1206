package com.example.bankproject.service.impl;

import com.example.bankproject.entity.UserProfile;
import com.example.bankproject.payload.UserProfileDto;
import com.example.bankproject.repository.UserProfileRepository;
import com.example.bankproject.service.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }


    public UserProfileDto addUser(UserProfileDto userProfileDto) {
        UserProfile userProfile = modelMapper.map(userProfileDto, UserProfile.class);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return modelMapper.map(savedUserProfile, UserProfileDto.class);
    }

    @Override
    public List<UserProfileDto> getAll() {
        return userProfileRepository.findAll().stream().map(a -> modelMapper.map(a, UserProfileDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserProfileDto getById(Long id) {
        return modelMapper.map(userProfileRepository.findById(id).orElseThrow(), UserProfileDto.class);
    }

    @Override
    public List<UserProfile> findByIdBetween(Long startId, Long endId) {
        return userProfileRepository.findByIdBetween(startId, endId);
    }
}

package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.exception.ResourceNotFoundException;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserProfileDto> getAllUserProfile() {
        List<UserProfile> userProfiles = userProfileRepo.findAllByOrderByNameAsc();
        List<UserProfileDto> userProfileDtos = userProfiles.stream().map(userProfile -> modelMapper.map(userProfile, UserProfileDto.class)).collect(Collectors.toList());
        return userProfileDtos;
    }

    @Override
    public List<AccountDtoWithoutUserProfile> getAllAccountsByUserId(Long userId) {
        UserProfile userProfile = userProfileRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserProfile","userId",userId));
        List<AccountDtoWithoutUserProfile> accountDtos = userProfile.getAccounts().stream()
                .map(account -> modelMapper.map(account, AccountDtoWithoutUserProfile.class))
                .sorted(Comparator.comparing(AccountDtoWithoutUserProfile::getAccountID))
                .collect(Collectors.toList());
        return accountDtos;
    }
}

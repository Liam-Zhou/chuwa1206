package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.UserProfileRepository;
import com.chuwa.transaction.entity.UserProfile;
import com.chuwa.transaction.exception.ResourceNotFoundException;
import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;


    public UserProfileImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }


    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
        UserProfile toBeSaved = convertDtoToEntity(userProfileDto);
        UserProfile saved = this.userProfileRepository.save(toBeSaved);
        UserProfileDto response = convertEntityToDto(saved);
        return response;
    }



    @Override
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto, long id) {
        UserProfile user = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "userProfileId", id));

        if (userProfileDto.getAddress() != null)
            user.setAddress(userProfileDto.getAddress());
        if (userProfileDto.getEmail() != null)
            user.setEmail(userProfileDto.getEmail());
        if (userProfileDto.getName() != null)
            user.setName(userProfileDto.getName());
        if (userProfileDto.getPhone() != null)
            user.setPhone(userProfileDto.getPhone());

        UserProfile saved = this.userProfileRepository.save(user);
        UserProfileDto response = convertEntityToDto(saved);
        return response;
    }

    @Override
    public void deleteUserProfileById(long id) {
        this.userProfileRepository.deleteById(id);
    }

    @Override
    public List<UserProfileDto> getAllUserProfiles() {
        List<UserProfile> users = this.userProfileRepository.findAll();
        List<UserProfileDto> response = users.stream().map(user -> (convertEntityToDto(user))).collect(Collectors.toList());
        return response;
    }

//    @Override
//    public UserProfileDto getUserProfileByAccountId(long accountId) {
//        UserProfile user = userProfileRepository.findByAccountsId(accountId);
//        UserProfileDto res = convertEntityToDto(user);
//        return res;
//    }

    @Override
    public UserProfileDto getUserProfileById(long userId) {
        UserProfile users = userProfileRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserProfile", "userProfileId", userId));

        return convertEntityToDto(users);
    }

    private UserProfileDto convertEntityToDto(UserProfile saved) {
        UserProfileDto response = new UserProfileDto();
        response.setUserId(saved.getId());
        response.setAddress(saved.getAddress());
        response.setEmail(saved.getEmail());
        response.setName(saved.getName());
        response.setPhone(saved.getPhone());


        return response;
    }

    private UserProfile convertDtoToEntity(UserProfileDto userProfileDto) {
        UserProfile toBeSaved = new UserProfile();
        toBeSaved.setAddress(userProfileDto.getAddress());
        toBeSaved.setEmail(userProfileDto.getEmail());
        toBeSaved.setName(userProfileDto.getName());
        toBeSaved.setPhone(userProfileDto.getPhone());
        return toBeSaved;
    }
}

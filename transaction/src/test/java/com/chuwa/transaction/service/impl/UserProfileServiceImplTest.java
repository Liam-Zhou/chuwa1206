package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.UserProfileRepository;
import com.chuwa.transaction.entity.UserProfile;
import com.chuwa.transaction.payload.UserProfileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UserProfileServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileServiceImplTest.class);

    @Mock
    private UserProfileRepository userProfileRepositoryMock;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private UserProfileImpl userProfileServiceImpl;

    private UserProfileDto userProfileDto;
    private UserProfile userProfile;

    @BeforeEach
    void setUp() {
//        ModelMapper modelMapper = new ModelMapper();
        logger.info("Setting up the test data");
        this.userProfile = new UserProfile(1L, "name", "address", "phone", "email");
        this.userProfileDto = modelMapper.map(userProfile, UserProfileDto.class);
    }

    @Test
    public void testCreateUserProfile() {
        logger.info("Create account test case");
        // 1. define the mock behavior
        Mockito.when(userProfileRepositoryMock.save(ArgumentMatchers.any(UserProfile.class)))
                .thenReturn(userProfile);

        // 2. execute the method to be tested
        UserProfileDto result = userProfileServiceImpl.createUserProfile(userProfileDto);

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userProfileDto.getUserId(), result.getUserId());
        Assertions.assertEquals(userProfileDto.getName(), result.getName());
        Assertions.assertEquals(userProfileDto.getAddress(), result.getAddress());
        Assertions.assertEquals(userProfileDto.getPhone(), result.getPhone());
        Assertions.assertEquals(userProfileDto.getEmail(), result.getEmail());
    }

    @Test
    public void testUpdateUserProfile() {
        logger.info("Update account test case");
        // 1. define the mock behavior
        UserProfile updatedUserProfile = new UserProfile(1L, "name-updated", "address", "phone", "email");
        UserProfileDto userProfileDto = new UserProfileDto(1L, "name-updated", "address", "phone", "email");

        Mockito.when(userProfileRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(userProfile));
        Mockito.when(userProfileRepositoryMock.save(ArgumentMatchers.any(UserProfile.class)))
                .thenReturn(updatedUserProfile);

        // 2. execute the method to be tested
        UserProfileDto result = userProfileServiceImpl.updateUserProfile(userProfileDto, 1L);

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(userProfileDto.getUserId(), result.getUserId());
        Assertions.assertEquals(userProfileDto.getName(), result.getName());
        Assertions.assertEquals(userProfileDto.getAddress(), result.getAddress());
        Assertions.assertEquals(userProfileDto.getPhone(), result.getPhone());
        Assertions.assertEquals(userProfileDto.getEmail(), result.getEmail());
    }

    @Test
    public void testGetAllUser() {
        logger.info("Get all user test case");
        java.util.List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(userProfile);
        // 1. mockito behavior
        Mockito.when(userProfileRepositoryMock.findAll())
                .thenReturn(userProfiles);

        // 2. execute the method to be tested
        List<UserProfileDto> result = userProfileServiceImpl.getAllUserProfiles();

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(userProfile.getId(), result.get(0).getUserId());
        Assertions.assertEquals(userProfile.getName(), result.get(0).getName());
        Assertions.assertEquals(userProfile.getAddress(), result.get(0).getAddress());
        Assertions.assertEquals(userProfile.getPhone(), result.get(0).getPhone());
        Assertions.assertEquals(userProfile.getEmail(), result.get(0).getEmail());

    }

    @Test
    public void testGetUserById() {
        Mockito.when(userProfileRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(userProfile));

        UserProfileDto result = userProfileServiceImpl.getUserProfileById(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(userProfile.getId(), result.getUserId());
        Assertions.assertEquals(userProfile.getName(), result.getName());
        Assertions.assertEquals(userProfile.getAddress(), result.getAddress());
        Assertions.assertEquals(userProfile.getPhone(), result.getPhone());
        Assertions.assertEquals(userProfile.getEmail(), result.getEmail());

    }

    @Test
    public void testDeleteUserById() {
//        Mockito.when(userProfileRepositoryMock.findById(ArgumentMatchers.anyLong()))
//                .thenReturn(Optional.ofNullable(userProfile));

        Mockito.doNothing().when(userProfileRepositoryMock).deleteById(1L);

        userProfileServiceImpl.deleteUserProfileById(1L);
        Mockito.verify(userProfileRepositoryMock, Mockito.times(1)).deleteById(1L);
    }

}

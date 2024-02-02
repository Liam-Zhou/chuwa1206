package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.payload.TxnResponsePageable;
import com.example.bankstatement.payload.UserProfileDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Alex D.
 */
@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(TxnServiceImplTest.class);

    @Mock
    private UserProfileRepo userProfileRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    private UserProfile userProfile;
    private UserProfileDto userProfileDto;
    private AccountDtoWithoutUserProfile accountDtoWithoutUserProfile;

    @BeforeEach
    void setUp(){
        logger.info("set up account for each test");
        this.userProfile = new UserProfile(1L,"abc","efg","757123456","abc@gmail.com", LocalDateTime.now(),LocalDateTime.now());
        this.userProfileDto = modelMapper.map(userProfile,UserProfileDto.class);
        logger.info("successful setup");
    }

    @Test
    void testCreateUserProfile() {
        when(userProfileRepo.save(any(UserProfile.class))).thenReturn(userProfile);

        UserProfileDto result = userProfileService.createUserProfile(userProfileDto);

        assertNotNull(result);
        assertEquals(userProfile.getName(), result.getName());
        verify(userProfileRepo).save(any(UserProfile.class));
    }

    @Test
    void testGetAllUserProfile() {
        List<UserProfile> userProfileList = Collections.singletonList(userProfile);
        when(userProfileRepo.findAllByOrderByNameAsc()).thenReturn(userProfileList);

        List<UserProfileDto> result = userProfileService.getAllUserProfile();

        assertFalse(result.isEmpty());
        assertEquals(userProfileList.size(), result.size());
        verify(userProfileRepo).findAllByOrderByNameAsc();
    }

    @Test
    void testGetAllAccountsByUserId() {
        Long userId = 1L;
        Account account = new Account(1L,1L,1L,1L,null, this.userProfile,LocalDateTime.now(),LocalDateTime.now());
        Set<Account> set = new HashSet<>();
        set.add(account);
        userProfile.setAccounts(set);

        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));

        List<AccountDtoWithoutUserProfile> result = userProfileService.getAllAccountsByUserId(userId);

        assertFalse(result.isEmpty());
        verify(userProfileRepo).findById(userId);
    }

    @Test
    void testGetUserProfileByUserId() {
        Long userId = 1L;
        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));

        UserProfileDto result = userProfileService.getUserProfileByUserId(userId);

        assertNotNull(result);
        assertEquals(userProfile.getName(), result.getName());
        verify(userProfileRepo).findById(userId);
    }

    @Test
    void testUpdateUserProfile() {
        Long userId = 1L;
        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));
        when(userProfileRepo.save(any(UserProfile.class))).thenReturn(userProfile);

        UserProfileDto result = userProfileService.updateUserProfile(userId, userProfileDto);

        assertNotNull(result);
        assertEquals(userProfileDto.getName(), result.getName());
        verify(userProfileRepo).findById(userId);
        verify(userProfileRepo).save(any(UserProfile.class));
    }

    @Test
    void testDeleteUserProfile() {
        Long userId = 1L;
        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));

        userProfileService.deleteUserProfile(userId);

        verify(userProfileRepo).findById(userId);
        verify(userProfileRepo).delete(userProfile);
    }
}
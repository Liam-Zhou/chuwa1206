package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.dao.UserProfileRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Alex D.
 */
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImplTest.class);

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private UserProfileRepo userProfileRepo;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    private AccountDto accountDto;
    private Account account;
    private UserProfile userProfile;
    private AccountDtoWithoutUserProfile accountDtoWithoutUserProfile;

    @BeforeEach
    void setUp(){
        logger.info("set up account for each test");
        this.userProfile = new UserProfile(1L,"abc","efg","757123456","abc@gmail.com",LocalDateTime.now(),LocalDateTime.now());
        this.account = new Account(1L,1L,1L,1L,null, this.userProfile,LocalDateTime.now(),LocalDateTime.now());
        this.accountDto = modelMapper.map(this.account,AccountDto.class);
        this.accountDtoWithoutUserProfile = modelMapper.map(this.account,AccountDtoWithoutUserProfile.class);
        logger.info("successful setup");
    }

    @Test
    void testCreateAccount() {
        long userId = 1L;
        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));
        when(accountRepo.save(any(Account.class))).thenReturn(account);

        AccountDto result = accountService.createAccount(userId, accountDto);

        assertNotNull(result);
        assertEquals(account.getId(), result.getId());
        verify(userProfileRepo).findById(userId);
        verify(accountRepo).save(any(Account.class));
    }

    @Test
    void testGetAccountByUserId() {
        long userId = 1L;
        when(userProfileRepo.findById(userId)).thenReturn(Optional.of(userProfile));

        List<AccountDtoWithoutUserProfile> result = accountService.getAccountByUserId(userId);

        assertNotNull(result);
        verify(userProfileRepo).findById(userId);
    }

    @Test
    void testGetAccountByUserIdByAccountId() {
        long accountId = 1L;
        when(accountRepo.findById(accountId)).thenReturn(Optional.of(account));

        AccountDto result = accountService.getAccountByUserIdByAccountId(1L, accountId);

        assertNotNull(result);
        assertEquals(account.getId(), result.getId()); // Example assertion
        verify(accountRepo).findById(accountId);
    }

    @Test
    void testUpdateAccountByUserIdAccountId() {
        long accountId = 1L;
        when(accountRepo.findById(accountId)).thenReturn(Optional.of(account));
        when(accountRepo.save(any(Account.class))).thenReturn(account);

        AccountDtoWithoutUserProfile result = accountService.updateAccountByUserIdAccountId(1L, accountId, accountDtoWithoutUserProfile);

        assertNotNull(result);
        verify(accountRepo).findById(accountId);
        verify(accountRepo).save(any(Account.class));
    }
    @Test
    void testDeleteAccountByUserIdAccountId() {
        long accountId = 1L;
        when(accountRepo.findById(accountId)).thenReturn(Optional.of(account));

        accountService.deleteAccountByUserIdAccountId(1L, accountId);

        verify(accountRepo).findById(accountId);
        verify(accountRepo).delete(any(Account.class));
    }

    @Test
    void testGetAllAccounts() {
        when(accountRepo.findAll()).thenReturn(Collections.singletonList(account));

        List<Account> result = accountService.getAllAccounts();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(accountRepo).findAll();
    }



}
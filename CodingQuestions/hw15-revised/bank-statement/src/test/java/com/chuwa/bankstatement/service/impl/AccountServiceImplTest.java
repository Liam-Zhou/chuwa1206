package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImplTest.class);

    @Mock
    private AccountRepository accountRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private AccountServiceImpl accountService;

    private Account account;
    private AccountDto accountDto;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }



    @BeforeEach
    void setUp() {
        logger.info("set up Post for each test");
        // Initialize your test account and accountDto here
        account = new Account(/* set properties */);
        accountDto = modelMapper.map(account, AccountDto.class);
    }

    @Test
    void getAllTest() {
        when(accountRepository.findAll()).thenReturn(Arrays.asList(account));

        List<AccountDto> result = accountService.getAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Compare individual attributes instead of the whole object
        assertEquals(accountDto.getAccountId(), result.get(0).getAccountId());
        assertEquals(accountDto.getUserId(), result.get(0).getUserId());
        // Continue with other relevant attributes...
    }

    @Test
    void getByIdTest() {
        when(accountRepository.findById(any())).thenReturn(Optional.of(account));

        AccountDto result = accountService.getById(1L);

        assertNotNull(result);
        // Again, compare individual attributes
        assertEquals(accountDto.getAccountId(), result.getAccountId());
        assertEquals(accountDto.getUserId(), result.getUserId());
        // And so on for other attributes...
    }


    @Test
    void createAccountTest() {
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        AccountDto result = accountService.createAccount(accountDto);

        assertNotNull(result);
        assertEquals(accountDto.getAccountId(), result.getAccountId());
        assertEquals(accountDto.getUserId(), result.getUserId());
        assertEquals(accountDto.getRoutingNumber(), result.getRoutingNumber());
        assertEquals(accountDto.getAccountNumber(), result.getAccountNumber());
    }


    @Test
    void findByUserIdBetweenTest() {
        when(accountRepository.findByUserIdBetween(any(Long.class), any(Long.class))).thenReturn(Arrays.asList(account));

        List<AccountDto> result = accountService.findByUserIdBetween(1L, 2L);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        AccountDto expectedDto = result.get(0);
        assertEquals(accountDto.getAccountId(), expectedDto.getAccountId());
        assertEquals(accountDto.getUserId(), expectedDto.getUserId());
        assertEquals(accountDto.getRoutingNumber(), expectedDto.getRoutingNumber());
        assertEquals(accountDto.getAccountNumber(), expectedDto.getAccountNumber());
    }

}
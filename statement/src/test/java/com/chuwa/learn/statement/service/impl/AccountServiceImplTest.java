package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.AccountRepoitory;
import com.chuwa.learn.statement.dao.UserRepository;
import com.chuwa.learn.statement.entity.Account;
import com.chuwa.learn.statement.entity.User;
import com.chuwa.learn.statement.payload.AccountDto;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepoitory accountRepoitory;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    private Account account;
    private AccountDto accountDto;

    @BeforeAll
    static void beforeAll() {
        log.info("START test");
    }

    @BeforeEach
    void setUp(){
        log.info("set up Post for each test");
        this.account = new Account(1L,1L, "1112223333","4444444",LocalDateTime.now(),LocalDateTime.now());
        this.accountDto = modelMapper.map(this.account,AccountDto.class);
    }

    @Test
    void testCreateAccount() {
        Mockito.when(accountRepoitory.save(ArgumentMatchers.any(Account.class))).thenReturn(account);
        AccountDto result = accountService.createAccount(accountDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getAccountId(),accountDto.getAccountId());
        Assertions.assertEquals(result.getAccountNumber(),accountDto.getAccountNumber());
        Assertions.assertEquals(result.getUserId(),accountDto.getUserId());
        Assertions.assertEquals(result.getAccountId(),accountDto.getAccountId());
    }

    @Test
    void testGetAccountById() {
        long id = 1L;
        Mockito.when(accountRepoitory.findById(id)).thenReturn(Optional.of(account));
        AccountDto result = accountService.getAccountById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getAccountId(),accountDto.getAccountId());
        Assertions.assertEquals(result.getAccountNumber(),accountDto.getAccountNumber());
        Assertions.assertEquals(result.getUserId(),accountDto.getUserId());
        Assertions.assertEquals(result.getAccountId(),accountDto.getAccountId());
    }
}
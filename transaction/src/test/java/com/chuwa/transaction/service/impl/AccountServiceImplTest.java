package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.AccountRepository;
import com.chuwa.transaction.entity.Account;
import com.chuwa.transaction.payload.AccountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Collections.singletonList;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImplTest.class);

    @Mock
    private AccountRepository accountRepositoryMock;

    @InjectMocks
    private AccountImpl accountService;

    private AccountDto accountDto;
    private Account account;

    @BeforeAll
    static void beforeAll() {
        logger.info("Before all test cases");
    }

    @BeforeEach
    void setUp() {
        logger.info("Before each test case");
        this.accountDto = new AccountDto(1L, 1L, "rou123456789", "acc123456789");
        this.account = new Account(1L,"rou123456789", "acc123456789", 1L);
    }

    @Test
    public void createAccount() {
        logger.info("Create account test case");
        // 1. define the mock behavior
        Mockito.when(accountRepositoryMock.save(ArgumentMatchers.any(Account.class)))
                .thenReturn(account);

        // 2. execute the method to be tested
        AccountDto result = accountService.createAccount(accountDto);

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(accountDto.getAccountId(), result.getAccountId());
        Assertions.assertEquals(accountDto.getUserId(), result.getUserId());
        Assertions.assertEquals(accountDto.getAccountNumber(), result.getAccountNumber());
        Assertions.assertEquals(accountDto.getRoutingNumber(), result.getRoutingNumber());
    }

    @Test
    public void findAccountsByUserId() {
        logger.info("Find accounts by user id test case");
        // 1. define the mock behavior
        Mockito.when(accountRepositoryMock.findByUserId(ArgumentMatchers.anyLong()))
                .thenReturn(singletonList(account));

        // 2. execute the method to be tested
        java.util.List<AccountDto> result = accountService.findAccountsByUserId(1L);

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(account.getUserId(), result.get(0).getUserId());
        Assertions.assertEquals(account.getAccountNumber(), result.get(0).getAccountNumber());
        Assertions.assertEquals(account.getRoutingNumber(), result.get(0).getRoutingNumber());
    }

}

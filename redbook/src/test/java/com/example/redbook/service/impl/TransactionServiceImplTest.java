package com.example.redbook.service.impl;

import com.example.redbook.dao.TransactionRepository;
import com.example.redbook.dao.UserProfileRepository;
import com.example.redbook.entity.Account;
import com.example.redbook.entity.Transaction;
import com.example.redbook.entity.UserProfile;
import com.example.redbook.payload.TransactionDto;
import com.example.redbook.payload.UserAccountDto;
import com.example.redbook.payload.UserTransactionDto;
import com.example.redbook.service.UserProfileService;
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

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImplTest.class);

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private UserProfileRepository userProfileRepository;

    @Mock
    private UserProfileService userProfileService;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private UserAccountDto userAccountDto;

    private TransactionDto transactionDto;

    private Transaction transaction;

    private Account account;

    private UserProfile userProfile;

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void setUp() {
        logger.info("set up transaction for each test");
        this.account = new Account(1, 1);
        LocalDateTime testDate = LocalDateTime.of(2024, 1, 15, 3, 0);
        this.transaction = new Transaction(account, testDate, 10, "test");
        this.transactionDto = modelMapper.map(this.transaction, TransactionDto.class);

        this.userAccountDto = new UserAccountDto(1L, "John Doe", "123 Main St", "123-456-7890", "john.doe@example.com", 1, 1, LocalDateTime.now(), LocalDateTime.now());

        // Creating a UserProfile for testing UserProfileService
        this.userProfile = new UserProfile();
        this.userProfile.setAccount(account);
        this.userProfile.setName("John Doe");
        this.userProfile.setAddr("123 Main St");
        this.userProfile.setPhone("123-456-7890");
        this.userProfile.setEmail("john.doe@example.com");
        this.userProfile.setCreateDateTime(LocalDateTime.now());
        this.userProfile.setUpdateDateTime(LocalDateTime.now());
        this.userProfile.setAccount(account);
    }

    @Test
    void testGetUserTransactions() {
        //define the behaviors
        when(userProfileService.getAccount(anyLong())).thenReturn(userAccountDto);
        when(transactionRepository.findByAccountAccountIdAndDateBetween(anyLong(), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(transaction));

        // execute
        UserTransactionDto result = transactionService.getUserTransactions(1L, LocalDateTime.now(), LocalDateTime.now());


        assertNotNull(result);
        assertNotNull(result.getTransactions());

        // Assertions on the transactions list
        assertEquals(userAccountDto.getName(), result.getUserName());
        assertEquals(userAccountDto.getAddr(), result.getAddr());
        assertEquals(userAccountDto.getAccountId(), result.getAccountId());


        List<TransactionDto> transactions = result.getTransactions();
        assertNotNull(transactions);
        assertEquals(1, transactions.size()); // Check the size
        TransactionDto retrievedTransaction = transactions.get(0);
        assertNotNull(retrievedTransaction);
        assertEquals(transaction.getDate(), retrievedTransaction.getDate());
        assertEquals(transaction.getDescription(), retrievedTransaction.getDescription());
        assertEquals(transaction.getAmount(), retrievedTransaction.getAmount());
    }

}

package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.TransactionRepository;
import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.payload.TransactionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImplTest.class);

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @InjectMocks
    private TransactionImpl transactionService;

    private TransactionDto transactionDto;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        logger.info("Before each test case");
        LocalDateTime localDateTime = LocalDateTime.now();
        BigDecimal userBigDecimal = new BigDecimal(100.0);
        this.transaction = new Transaction(1L,1L, localDateTime, "deposit", userBigDecimal);
        this.transactionDto = new TransactionDto(1L,1L, "deposit", userBigDecimal, localDateTime);
        logger.info("Before each test case Dto: " + this.transactionDto.getAccountId());
        logger.info("Before each test case Entity: " + this.transaction.getAccountId());
    }

    @Test
    public void createTransaction() {
        logger.info("Create transaction test case");
        // 1. define the mock behavior
        Mockito.when(transactionRepositoryMock.save(ArgumentMatchers.any(Transaction.class)))
                .thenReturn(transaction);

        // 2. execute the method to be tested
        TransactionDto result = transactionService.createTransaction(transactionDto);

        // 3. verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals(transactionDto.getTransactionId(), result.getTransactionId());
        Assertions.assertEquals(transactionDto.getAccountId(), result.getAccountId());
        Assertions.assertEquals(transactionDto.getDescription(), result.getDescription());
        Assertions.assertEquals(transactionDto.getAmount(), result.getAmount());
        Assertions.assertEquals(transactionDto.getCreateDateTime(), result.getCreateDateTime());
    }


}

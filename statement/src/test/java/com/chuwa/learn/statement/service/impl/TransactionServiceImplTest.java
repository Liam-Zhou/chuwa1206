package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.TransactionRepository;
import com.chuwa.learn.statement.entity.Account;
import com.chuwa.learn.statement.entity.Transaction;
import com.chuwa.learn.statement.payload.AccountDto;
import com.chuwa.learn.statement.payload.TransactionDto;
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
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@Slf4j
@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Spy
    private ModelMapper modelMapper;
    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Transaction transaction;
    private TransactionDto transactionDto;
    @BeforeAll
    static void beforeAll() {
        log.info("START test");
    }

    @BeforeEach
    void setUp(){
        log.info("set up Post for each test");
        this.transaction = new Transaction(1L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"t1",100);
        this.transactionDto = modelMapper.map(transaction, TransactionDto.class);
    }
    @Test
    void createTransaction() {
        Mockito.when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        TransactionDto result = transactionService.createTransaction(transactionDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getAccountId(), transactionDto.getAccountId());
        Assertions.assertEquals(result.getAmount(), transactionDto.getAmount());
        Assertions.assertEquals(result.getDescription(),transactionDto.getDescription());
        Assertions.assertEquals(result.getDate(),transactionDto.getDate());
    }

    @Test
    void getTransactions() {
        Transaction transaction1 = new Transaction(1L,LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),"t2",50);
        TransactionDto transactionDto1 = modelMapper.map(transaction1, TransactionDto.class);
        Mockito.when(transactionRepository.findByAccountIdAndDateBetween(anyLong(), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Arrays.asList(transaction, transaction1));

        List<TransactionDto> result = transactionService.getTransactions(1L, LocalDateTime.now().minusDays(2), LocalDateTime.now());
        Assertions.assertEquals(result.size(),2);
        Assertions.assertEquals(result.get(0).getAmount(),transactionDto.getAmount());
        Assertions.assertEquals(result.get(1).getAmount(),transactionDto1.getAmount());
    }
}
package com.chuwa.learn.statement.service;

import com.chuwa.learn.statement.payload.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactions(long id, LocalDateTime startDate, LocalDateTime endDate);
    void storeTransactions();
}

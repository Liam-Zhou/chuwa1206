package com.chuwa.transaction.service;

import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.payload.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);

    List<TransactionDto> getTransactionByAccountIdAndTimeRange(long accountId, LocalDateTime a, LocalDateTime b);

}

package com.chuwa.transaction.service;

import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.payload.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    TransactionDto updateTransaction(TransactionDto transactionDto, long id);
    TransactionDto deleteTransaction(long id);

    List<TransactionDto> getTransactionByAccountIdAndTimeRange(long accountId, LocalDateTime a, LocalDateTime b);

}

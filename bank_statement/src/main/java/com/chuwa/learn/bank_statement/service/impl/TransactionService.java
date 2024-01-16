package com.chuwa.learn.bank_statement.service.impl;

import com.chuwa.learn.bank_statement.payload.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactions(LocalDate startDate, LocalDate endDate);

}

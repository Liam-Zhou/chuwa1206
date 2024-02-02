package com.example.bank.statement.service;

import com.example.bank.statement.payload.TransactionDto;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    TransactionDto getTransactionById(long id);
}

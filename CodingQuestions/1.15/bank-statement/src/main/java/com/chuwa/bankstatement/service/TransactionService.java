package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(Long userId, Long accountId, TransactionDto transactionDto);

    TransactionDto updateTransaction(Long transactionId, TransactionDto transactionDto);

    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionById(Long transactionId);

    void deleteTransactionById(Long transactionId);
}

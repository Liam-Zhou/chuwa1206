package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.TransactionDto;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
}

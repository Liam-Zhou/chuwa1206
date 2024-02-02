package com.example.bankproject.service;

import com.example.bankproject.payload.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionById(Long id);

    TransactionDto createTransaction(TransactionDto transactionDto);

    List<TransactionDto> getAllByAccountId(Long accountId);

    List<TransactionDto> findByAccountIdIn(List<Long> accountIds);

    List<TransactionDto> getTransactionsByDateRange(LocalDate startDate, LocalDate endDate);
}

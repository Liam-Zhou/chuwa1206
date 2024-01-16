package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);
    TransactionDto getTransactionById(long id);
    List<TransactionDto> getTransactionByAccountAndDateRange(long accountId, LocalDate startDate, LocalDate endDate);
    List<TransactionDto> getTransactionsByUserAndDateRange(long userId, LocalDate startDate, LocalDate endDate);
    List<TransactionDto> getAllTransactions();
    TransactionDto updateTransaction(TransactionDto transactionDto, long id);
    void deleteTransaction(long id);
}

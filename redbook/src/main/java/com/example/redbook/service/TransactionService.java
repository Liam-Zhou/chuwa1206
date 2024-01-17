package com.example.redbook.service;

import com.example.redbook.entity.Transaction;
import com.example.redbook.payload.UserTransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    public UserTransactionDto getUserTransactions(long userId, LocalDateTime from, LocalDateTime to);
}

package com.example.redbook.service;

import com.example.redbook.entity.Transaction;
import com.example.redbook.payload.UserTransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TransactionService {
    public UserTransactionDto getUserTransactions(long userId, LocalDateTime from, LocalDateTime to);
}

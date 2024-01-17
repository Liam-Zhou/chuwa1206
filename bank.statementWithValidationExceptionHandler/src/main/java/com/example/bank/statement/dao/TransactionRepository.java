package com.example.bank.statement.dao;

import com.example.bank.statement.entity.Account;
import com.example.bank.statement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByAccountAndDateBetween(Account account, LocalDateTime startDate, LocalDateTime endDate);
}

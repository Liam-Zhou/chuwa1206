package com.example.bankproject.repository;

import com.example.bankproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);

    List<Transaction> findByAccountIdIn(List<Long> accountIds);

    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

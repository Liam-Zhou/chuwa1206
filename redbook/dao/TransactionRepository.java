package com.example.redbook.dao;

import com.example.redbook.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountAccountIdAndDateBetween(Long accountId, LocalDateTime fromDate, LocalDateTime toDate);

}

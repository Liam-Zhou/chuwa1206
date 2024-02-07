package com.chuwa.learn.statement.dao;

import com.chuwa.learn.statement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccountIdAndDateBetween(Long id, LocalDateTime date, LocalDateTime date2);
}

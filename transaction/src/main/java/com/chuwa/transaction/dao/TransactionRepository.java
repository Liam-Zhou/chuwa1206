package com.chuwa.transaction.dao;

import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountIdAndCreateDateTimeBetween(long id, LocalDateTime a, LocalDateTime b);
}

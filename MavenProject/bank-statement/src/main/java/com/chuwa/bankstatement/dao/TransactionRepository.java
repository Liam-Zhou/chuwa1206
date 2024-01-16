package com.chuwa.bankstatement.dao;

import com.chuwa.bankstatement.entity.Account;
import com.chuwa.bankstatement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xiaorui
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountAndTimeBetween(Account account, LocalDateTime startTime, LocalDateTime endTime);
}

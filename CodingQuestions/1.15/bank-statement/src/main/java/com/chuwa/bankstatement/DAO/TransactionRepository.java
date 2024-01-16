package com.chuwa.bankstatement.DAO;

import com.chuwa.bankstatement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByCreateDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Transaction> findTransactionsByAccountIdAndCreateDateTimeBetween(Long accountId, LocalDateTime start, LocalDateTime end);

    List<Transaction> findByAccountIdAndCreateDateTimeGreaterThanEqualAndCreateDateTimeLessThan(Long accountId, LocalDateTime start, LocalDateTime end);
}

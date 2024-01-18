package com.example.bankstatement.dao;

import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.Txn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Alex D.
 */
@Repository
public interface TxnRepo extends JpaRepository<Txn, Long> {
    Set<Txn> findAllByAccountAccountIDOrderByCreateDateTimeDesc(Long accountId);

    Set<Txn> findAllByAccount_AccountIDAndCreateDateTimeBetweenOrderByCreateDateTimeDesc(
        Long accountId,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime
    );
}

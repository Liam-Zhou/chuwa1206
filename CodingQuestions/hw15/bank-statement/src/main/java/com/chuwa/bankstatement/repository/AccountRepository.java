package com.chuwa.bankstatement.repository;

import com.chuwa.bankstatement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserIdBetween(Long startId, Long endId);
}

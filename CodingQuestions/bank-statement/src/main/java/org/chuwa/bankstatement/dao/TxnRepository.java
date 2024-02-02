package org.chuwa.bankstatement.dao;

import org.chuwa.bankstatement.entities.Account;
import org.chuwa.bankstatement.entities.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TxnRepository extends JpaRepository<Txn, Long> {
    List<Txn> findAllByAccountAndDateBetween(Account account, Integer startMonth, Integer endMonth);
}

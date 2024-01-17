package com.chuwa.BankStatement.dao;

import com.chuwa.BankStatement.entity.Account;
import com.chuwa.BankStatement.entity.Txn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface TxnRepository extends JpaRepository<Txn, Long> {
    List<Txn> findAllByAccountAndDateBetween(Account account, Date startDate, Date endDate);
}

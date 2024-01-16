package com.chuwa.learn.bank_statement.dao;

import com.chuwa.learn.bank_statement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}

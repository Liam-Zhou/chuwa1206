package com.chuwa.learn.bank_statement.dao;

import com.chuwa.learn.bank_statement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepoitory extends JpaRepository<Account,Long> {
}

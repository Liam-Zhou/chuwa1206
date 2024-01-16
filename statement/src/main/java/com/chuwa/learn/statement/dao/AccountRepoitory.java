package com.chuwa.learn.statement.dao;

import com.chuwa.learn.statement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepoitory extends JpaRepository<Account,Long> {
}

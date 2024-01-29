package com.chuwa.statement.dao;

import com.chuwa.statement.entity.Account;
import com.chuwa.statement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByUser(User user);
}

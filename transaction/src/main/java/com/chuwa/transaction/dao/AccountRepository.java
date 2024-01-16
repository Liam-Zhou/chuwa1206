package com.chuwa.transaction.dao;

import com.chuwa.transaction.entity.Account;
import com.chuwa.transaction.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(long userId);
}

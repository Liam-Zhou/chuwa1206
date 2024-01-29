package com.example.bank.statement.dao;

import com.example.bank.statement.entity.Account;
import com.example.bank.statement.entity.UserProfile;
import com.example.bank.statement.payload.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserProfile(UserProfile userProfile);
}

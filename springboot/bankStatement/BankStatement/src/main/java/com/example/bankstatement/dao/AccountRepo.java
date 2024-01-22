package com.example.bankstatement.dao;

import com.example.bankstatement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex D.
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}

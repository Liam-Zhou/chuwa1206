package org.chuwa.bankstatement.dao;

import org.chuwa.bankstatement.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

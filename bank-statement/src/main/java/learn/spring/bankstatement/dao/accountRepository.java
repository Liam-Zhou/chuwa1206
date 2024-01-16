package learn.spring.bankstatement.dao;

import learn.spring.bankstatement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<Account, Long> {
}

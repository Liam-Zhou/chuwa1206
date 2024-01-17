package learn.spring.bankstatement.dao;

import learn.spring.bankstatement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepository extends JpaRepository<Transaction, Long> {
}

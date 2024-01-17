package learn.spring.bankstatement.dao;

import learn.spring.bankstatement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

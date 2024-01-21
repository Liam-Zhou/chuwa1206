package org.chuwa.bankstatement.dao;

import org.chuwa.bankstatement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

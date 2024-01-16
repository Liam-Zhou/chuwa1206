package com.chuwa.learn.bank_statement.dao;

import com.chuwa.learn.bank_statement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

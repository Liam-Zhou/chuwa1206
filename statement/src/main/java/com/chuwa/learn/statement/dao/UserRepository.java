package com.chuwa.learn.statement.dao;

import com.chuwa.learn.statement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

package com.chuwa.redbook.dao;

import com.chuwa.redbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}

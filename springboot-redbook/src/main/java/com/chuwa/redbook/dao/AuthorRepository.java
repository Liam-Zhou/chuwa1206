package com.chuwa.redbook.DAO;

import com.chuwa.redbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
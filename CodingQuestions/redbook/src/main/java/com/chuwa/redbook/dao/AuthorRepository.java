package com.chuwa.redbook.dao;

import com.chuwa.redbook.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

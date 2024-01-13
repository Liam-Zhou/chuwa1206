package com.example.redbook.dao;

import com.example.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
//Through Java Generics and Reflection, Spring Data JPA dynamically generates the implementation of these CRUD
//    methods at runtime based on the provided entity type (Post in this case).
package com.example.CassandraBlog.repository;

import com.example.CassandraBlog.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository

public interface PostRepository extends CrudRepository<Post, UUID> {

}

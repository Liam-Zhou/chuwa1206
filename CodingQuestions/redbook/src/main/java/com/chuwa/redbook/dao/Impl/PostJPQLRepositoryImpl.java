package com.chuwa.redbook.dao.Impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    @PersistenceContext // inject (or bind) an EntityManager instance into a field or method of a bean class.
    EntityManager entityManager;

    @Override
    public List<Post> getAllPostWithJPQL() {
        // TypedQuery<Post> is a type of JPA Query that provides a way to execute queries with a specific return type
        TypedQuery<Post> posts = entityManager.createNamedQuery("Post.getAll", Post.class); // preparing a query
        return posts.getResultList(); // actually execute the query and retrieve the results
    }
    @Override
    public Post insertPost(Post post) {
        // ID fields is optional
        return entityManager.merge(post);
    }
    @Override
    public Post updatePost(Post post) {
        // ID fields is required
        return entityManager.merge(post);
    }
    @Override
    public Post getPostById(Long id) {
        return entityManager.find(Post.class, id);
    }
    @Override
    public void deleteById(Long id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }
}

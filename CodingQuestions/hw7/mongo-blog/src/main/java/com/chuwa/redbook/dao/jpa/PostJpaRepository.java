package com.chuwa.redbook.dao.jpa;

import com.chuwa.redbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Diana
 */

// For SQL database
@Repository
public interface PostJpaRepository extends JpaRepository<Post, Long> {
    // SQL-specific operations
}

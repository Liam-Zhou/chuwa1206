package com.chuwa.KotlinRedbook.DAO

import com.chuwa.KotlinRedbook.Entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}
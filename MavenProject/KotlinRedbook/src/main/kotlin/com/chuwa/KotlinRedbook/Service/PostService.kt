package com.chuwa.KotlinRedbook.Service

import com.chuwa.KotlinRedbook.DAO.PostRepository
import com.chuwa.KotlinRedbook.Entity.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService {
    @Autowired
    lateinit var postRepository : PostRepository

    fun createPost(title : String, content : String?) : Post {
        var newPost : Post = Post(title, content)
        var saved : Post = postRepository.save(newPost)
        return saved
    }

    fun getPostById(id : Long) : Post? {
        var result = postRepository.findById(id).orElse(null)
        return result
    }

    fun getAllPost() : List<Post> {
        return postRepository.findAll()
    }
}
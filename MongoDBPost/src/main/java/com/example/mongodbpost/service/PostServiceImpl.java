package com.example.mongodbpost.service;
import com.example.mongodbpost.dao.PostRepository;
import com.example.mongodbpost.dto.PostDto;
import com.example.mongodbpost.entity.Post;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post newPost = postRepository.save(post);
        return convertToDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        // Implement logic to retrieve all posts and convert to DTOs
        return null;
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }
}

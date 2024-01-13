package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.DAO.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        Post saved = this.postRepository.save(tobeSaved);

        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());

        return response;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostServiceImpl::convertEntityToDto)
                .toList();
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertEntityToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatedPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if (postDto.getContent() != null) {
            toBeUpdatedPost.setContent(postDto.getContent());
        }
        if (postDto.getDescription() != null) {
            toBeUpdatedPost.setDescription(postDto.getDescription());
        }
        if (postDto.getTitle() != null) {
            toBeUpdatedPost.setTitle(postDto.getTitle());
        }
        Post updatedPost = postRepository.save(toBeUpdatedPost);

        return convertEntityToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    private static PostDto convertEntityToDto(Post saved) {
        PostDto response = new PostDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private static Post convertDtoToEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());
        return tobeSaved;
    }
}

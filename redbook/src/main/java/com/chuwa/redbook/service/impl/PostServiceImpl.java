package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
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
        // 为什么要Dto和Entity之间相互转换？
            // 因为Dto是传递给前端的payload，为了避免前端或后端出现更改，另一方需要同步改，
            // 因此拆分一层decouple
        // Dto to Entity
        Post tobeSaved = convertDTOtoEntity(postDto);

        Post save = this.postRepository.save(tobeSaved);

        // Entity to Dto
        PostDto response = convertEntityToDto(save);

        return response;
    }

    private PostDto convertEntityToDto(Post save) {
        PostDto response = new PostDto();
        response.setId(save.getId());
        response.setContent(save.getContent());
        response.setDescription(save.getDescription());
        response.setTitle(save.getTitle());
        return response;
    }

    private Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> convertEntityToDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new RecourceNotFoundException("Post", "id", id));

        return convertEntityToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new RecourceNotFoundException("Post", "id", id));

        //set前可以检查get是否为null
        if(postDto.getDescription() != null) {
            toBeUpdatePost.setDescription(postDto.getDescription());
        }
        if(postDto.getContent() != null) {
            toBeUpdatePost.setContent(postDto.getContent());
        }
        if(postDto.getTitle() != null) {
            toBeUpdatePost.setTitle(postDto.getTitle());
        }


        Post updatePost = this.postRepository.save(toBeUpdatePost);

        return convertEntityToDto(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }


}

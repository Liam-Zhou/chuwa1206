package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = converDTOtoEntity(postDto);

        Post saved = this.postRepository.save(tobeSaved);

        PostDto response = convertEntitytoDTO(saved);
        return response;
    }

    private static PostDto convertEntitytoDTO(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription((saved.getDescription()));
        response.setContent(saved.getContent());
        return response;
    }

    private static Post converDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription((postDto.getDescription()));
        tobeSaved.setContent(postDto.getContent());
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost(){
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(PostServiceImpl::convertEntitytoDTO).collect(Collectors.toList());
        return postDtos;
    }

//    @Override
//    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir){
//        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();
//
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
//        Page<Post> pagePosts = postRepository.findAll(pageRequest);
//
//        // get content for page object
//        List<Post> posts = pagePosts.getContent();
//        List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
//
//        PostResponse postResponse = new PostResponse();
//    }

    @Override
    public PostDto getPostById(long id){
        return convertEntitytoDTO(this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }
        toBeUpdatePost.setContent(postDto.getContent());

        // should check null for the other two
        toBeUpdatePost.setDescription((postDto.getDescription()));
        toBeUpdatePost.setTitle(postDto.getTitle());


        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return convertEntitytoDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }


}

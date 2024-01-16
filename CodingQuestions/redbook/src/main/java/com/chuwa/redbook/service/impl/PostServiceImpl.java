package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
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

    @Autowired
    private PostJPQLRepository postJPQLRepository;


    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = DTOtoEntity(postDto);
        Post saved = this.postRepository.save(tobeSaved);

        return EntityToDTO(saved);
    }


    @Override
    public List<PostDto> getAllPost() {
        //Entity --> DTO
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> EntityToDTO(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    //
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> EntityToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return EntityToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //#1, get original Post
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //#2, update data
        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }

        if(postDto.getDescription() != null){
            //If this is another Entity
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        if(postDto.getTitle() != null){
            toBeUpdatePost.setTitle(postDto.getTitle());
        }

        //#3, re-save the updated Post entity
        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return EntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL().stream().map(post -> EntityToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return EntityToDTO(post);
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return EntityToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return EntityToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return EntityToDTO(post);
    }



    private PostDto EntityToDTO(Post saved) {
        PostDto response = new PostDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private Post DTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        //from Entity to DTO
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());
        return tobeSaved;
    }
}

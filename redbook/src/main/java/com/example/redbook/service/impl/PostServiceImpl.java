package com.example.redbook.service.impl;

//import com.example.redbook.dao.PostCassandraRepository;
import com.example.redbook.dao.PostRepository;
import com.example.redbook.payload.dto.PostDto;
import com.example.redbook.entity.Post;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.PostResponse;
import com.example.redbook.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

//    private final PostCassandraRepository postCanssandrawRepo;
    private PostRepository postRepository;
    /**
     * @Autowired spring 4.3 onwards, the bean only have one constructor, so we omit
    constructor
     * @param postRepository
     */
//    public PostServiceImpl(PostRepository postRepository, PostCassandraRepository postCanssandrawRepo) {
//        this.postRepository = postRepository;
//        this.postCanssandrawRepo = postCanssandrawRepo;
//    }

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDTOtoEntity(postDto);
        Post saved = this.postRepository.save(tobeSaved);

        PostDto response = convertEntityToDTO(saved);
        return response;
    }

    private PostDto convertEntityToDTO(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        //from Entity to DTO
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> convertEntityToDTO(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertEntityToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        if (postDto.getContent() != null) {
            toBeUpdatePost.setContent(postDto.getContent());
        }

        if (postDto.getDescription() != null) {
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        if (postDto.getTitle() != null) {
            toBeUpdatePost.setTitle(postDto.getTitle());
        }

        Post updatePost = this.postRepository.save(toBeUpdatePost);

        return convertEntityToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

}


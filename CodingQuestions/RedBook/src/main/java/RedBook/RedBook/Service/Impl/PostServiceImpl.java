package RedBook.RedBook.Service.Impl;


import RedBook.RedBook.Entity.Post;
import RedBook.RedBook.Repository.PostRepository;
import RedBook.RedBook.Service.PostService;
import RedBook.RedBook.payload.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){

        this.postRepository = postRepository;
    }

    public Post MapperToPost(PostDTO postDTO){

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        return  post;
    }

    public PostDTO MapperTOPostDTO(Post post){

            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setContent(post.getContent());
            postDTO.setDescription(post.getDescription());
            postDTO.setTitle(post.getTitle());
            return postDTO;
    }

    public PostDTO savePosts(PostDTO postDTO){

        Post post = MapperToPost(postDTO);
        post = postRepository.save(post);
        postDTO = MapperTOPostDTO(post);
        return  postDTO;
    }

    @Override
    public List<PostDTO> getAll() {

        List<Post>posts = postRepository.findAll();

        return posts.stream()
                .map((post -> MapperTOPostDTO(post)))
                .collect(Collectors.toList());

    }

    @Override
    public PostDTO getById(long id) {
        Post post = postRepository.findById(id).orElseThrow();

        return MapperTOPostDTO(post);
    }

    @Override
    public PostDTO updateById(long id,PostDTO postDTO) {

        Post post = postRepository.findById(id).orElseThrow();

        post.setDescription(postDTO.getDescription());
        post.setTitle(post.getTitle());
        post.setDescription(post.getDescription());
        postRepository.save(post);

        return  postDTO =  MapperTOPostDTO(post);

    }


}

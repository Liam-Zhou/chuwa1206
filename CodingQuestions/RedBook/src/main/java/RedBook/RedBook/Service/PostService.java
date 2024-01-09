package RedBook.RedBook.Service;


import RedBook.RedBook.payload.PostDTO;

import java.util.List;

public interface PostService {

    public PostDTO savePosts(PostDTO postDTO);
    public List<PostDTO> getAll();
    public PostDTO getById(long id);

    PostDTO updateById(long id,PostDTO postDTO);
}

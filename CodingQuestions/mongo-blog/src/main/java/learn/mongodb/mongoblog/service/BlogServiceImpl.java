package learn.mongodb.mongoblog.service;

import learn.mongodb.mongoblog.model.Blog;
import learn.mongodb.mongoblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findBlogByAuthor(String author) {
        return blogRepository.findBlogByAuthor(author);
    }

    @Override
    public void saveBlog(String author, String content) {
        Blog blog = new Blog();
        blog.setAuthor(author);
        blog.setContent(content);
        blogRepository.save(blog);
    }
}

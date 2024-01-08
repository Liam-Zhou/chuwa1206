package learn.mongodb.mongoblog.service;

import learn.mongodb.mongoblog.model.Blog;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findBlogByAuthor(String author);
    void saveBlog(String author, String content);
}

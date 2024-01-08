package learn.mongodb.mongoblog.repository;

import learn.mongodb.mongoblog.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


// What makes Spring Data MongoDB so useful is the fact that you need not create this implementation.
// Spring Data MongoDB creates it on the fly when you run the application.
public interface BlogRepository extends MongoRepository<Blog, String> {


    @Query(value="{author:'?0'}", fields="{'author' : 1, 'content' : 1}")
        // value: field by which to filter the query
        // fields: only project name and quantity in the query response
    List<Blog> findBlogByAuthor(String author);

    public long count(); // reuse the method count() as it is

}

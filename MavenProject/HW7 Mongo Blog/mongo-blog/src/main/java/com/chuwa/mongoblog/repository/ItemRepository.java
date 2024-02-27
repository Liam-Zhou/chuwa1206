package com.chuwa.mongoblog.repository;

import com.chuwa.mongoblog.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {
    @Query("{name: ?0}")
    GroceryItem findItemByName(String name);

    //defining a custom query to find GroceryItem documents based on the category field while
    // specifying the fields to be included in the result.
    @Query(value = "{category: ?0}", fields = "{'name' :  1, 'quantity' :  true}")
    List<GroceryItem> findCate(String category);


    public long count();
}

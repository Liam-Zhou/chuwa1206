package learn.mongodb.mongoblog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("blogs")
// specify the collection name
// if the collection doesn't exist, MongoDB will create it
@Getter
@Setter
@NoArgsConstructor
public class Blog {

    @Id
    // primary key
    // If we don't do this, MongoDB will automatically generate an _id when creating the document
    private String id;

    private String author;
    private String content;

    public Blog(String id, String author, String contend) {
        this.id = id;
        this.author = author;
        this.content = contend;
    }
}

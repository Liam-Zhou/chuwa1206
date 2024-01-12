package com.chuwa.redbook.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// why DTO:
// decoupling the internal representation of data from the data that is presented to or consumed from external clients
// DTOs allow you to selectively send only the necessary data


@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String description;;
    private String content;

    public PostDto(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

}

package com.chuwa.redbook.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private long id;

    private String name;

    private String biography;

    public AuthorDto(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

}

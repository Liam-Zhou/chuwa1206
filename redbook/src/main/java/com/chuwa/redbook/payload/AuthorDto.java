package com.chuwa.redbook.payload;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuthorDto {
    private Long id;
    private String name;
    private String email;
}

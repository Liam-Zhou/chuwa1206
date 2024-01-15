package com.chuwa.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author xiaorui
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfileDto {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}

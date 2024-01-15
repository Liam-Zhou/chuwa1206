package com.chuwa.bankstatement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author xiaorui
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    @OneToOne(mappedBy = "userProfile")
    private Account account;
}

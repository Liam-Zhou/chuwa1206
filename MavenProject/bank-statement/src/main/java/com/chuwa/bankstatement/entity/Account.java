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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="user_profile_id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;

    private String routingNumber;

    private String accountNumber;
}

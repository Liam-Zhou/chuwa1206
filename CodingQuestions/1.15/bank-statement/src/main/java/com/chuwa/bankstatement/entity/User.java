package com.chuwa.bankstatement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Account> accounts;

    public User(String name, String address, String phone, String email, Set<Account> accounts) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }
}

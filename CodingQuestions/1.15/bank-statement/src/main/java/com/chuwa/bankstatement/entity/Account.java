package com.chuwa.bankstatement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "routing_number", nullable = false, unique = true)
    private String routingNumber;
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "account",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    @JsonManagedReference
    private Set<Transaction> transactions;

    public Account(String routingNumber, String accountNumber, User user, Set<Transaction> transactions) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.user = user;
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }
}

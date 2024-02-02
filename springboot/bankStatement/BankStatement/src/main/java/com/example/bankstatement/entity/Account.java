package com.example.bankstatement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex D.
 */
@Entity
@Table(
        name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_id"}),
                @UniqueConstraint(columnNames = {"account_number"}),
                @UniqueConstraint(columnNames = {"routing_number"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="account_id", nullable = false)
        private Long accountID;

        @Column(name = "routing_number", nullable = false)
        private Long routingNumber;

        @Column(name="account_number", nullable = false)
        private Long accountNumber;

        @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Txn> txns = new HashSet<>();

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private UserProfile user;

        @CreationTimestamp
        private LocalDateTime createDateTime;

        @UpdateTimestamp
        private LocalDateTime updateDateTime;

}

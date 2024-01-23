package com.example.bankstatement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
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
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="account_id", nullable = false)
        private Long accountID;

//        @Column(name="user_id", nullable = false)
//        private Long userId;

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

        public LocalDateTime getCreateDateTime() {
                return createDateTime;
        }

        public void setCreateDateTime(LocalDateTime createDateTime) {
                this.createDateTime = createDateTime;
        }

        public LocalDateTime getUpdateDateTime() {
                return updateDateTime;
        }

        public void setUpdateDateTime(LocalDateTime updateDateTime) {
                this.updateDateTime = updateDateTime;
        }

        public Account() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getAccountID() {
                return accountID;
        }

        public void setAccountID(Long accountID) {
                this.accountID = accountID;
        }

        public Long getRoutingNumber() {
                return routingNumber;
        }

        public void setRoutingNumber(Long routingNumber) {
                this.routingNumber = routingNumber;
        }

        public Long getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(Long accountNumber) {
                this.accountNumber = accountNumber;
        }

        public Set<Txn> getTxns() {
                return txns;
        }

        public void setTxns(Set<Txn> txns) {
                this.txns = txns;
        }

        public UserProfile getUser() {
                return user;
        }

        public void setUser(UserProfile user) {
                this.user = user;
        }
}

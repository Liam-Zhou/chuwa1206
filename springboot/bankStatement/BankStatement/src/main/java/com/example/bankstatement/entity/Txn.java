package com.example.bankstatement.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author Alex D.
 */
@Entity
@Table(
        name = "txn",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_id", "date_time"})
        }
)
public class Txn {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

//        @Column(name="account_id", nullable = false)
//        private Long accountID;

        @CreationTimestamp
        private LocalDateTime createDateTime;

        @UpdateTimestamp
        private LocalDateTime updateDateTime;

        @Column(name="description", nullable = true)
        private String description;

        @Column(name="amount", nullable = false)
        private Long amount;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "account_id", nullable = false)
        private Account account;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

//        public Long getAccountID() {
//                return accountID;
//        }
//
//        public void setAccountID(Long accountID) {
//                this.accountID = accountID;
//        }
        public Account getAccount() {
                return account;
        }

        public void setAccount(Account account) {
                this.account = account;
        }

        public LocalDateTime getDateTime() {
                return createDateTime;
        }

        public void setDateTime(LocalDateTime date_time) {
                this.createDateTime = date_time;
        }

        public LocalDateTime getUpdateDateTime() {
                return updateDateTime;
        }

        public void setUpdateDateTime(LocalDateTime updateDateTime) {
                this.updateDateTime = updateDateTime;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Long getAmount() {
                return amount;
        }

        public void setAmount(Long amount) {
                this.amount = amount;
        }

        public Txn() {
        }



        public Txn(Long id, LocalDateTime date_time, LocalDateTime updateDateTime, String description, Long amount, Account account) {
                this.id = id;
                this.createDateTime = date_time;
                this.updateDateTime = updateDateTime;
                this.description = description;
                this.amount = amount;
                this.account = account;
        }
}

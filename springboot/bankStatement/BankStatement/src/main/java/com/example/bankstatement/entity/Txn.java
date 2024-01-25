package com.example.bankstatement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author Alex D.
 */
@Entity
@Table(
        name = "txn"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Txn {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

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

}

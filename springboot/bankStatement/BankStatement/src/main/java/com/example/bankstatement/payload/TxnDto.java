package com.example.bankstatement.payload;

import com.example.bankstatement.entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author Alex D.
 */
public class TxnDto {
    private Long id;
    private LocalDateTime createDateTime;
    private String description;
    private Long amount;
    private Account account;
}

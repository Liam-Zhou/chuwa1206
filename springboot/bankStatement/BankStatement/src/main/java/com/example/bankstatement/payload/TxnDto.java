package com.example.bankstatement.payload;

import com.example.bankstatement.entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TxnDto {
    private Long id;
    private LocalDateTime createDateTime;
    private String description;
    private Long amount;
//    private AccountDto account;
}

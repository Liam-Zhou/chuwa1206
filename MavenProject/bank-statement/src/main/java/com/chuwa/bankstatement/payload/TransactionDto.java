package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.entity.Account;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author xiaorui
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private long id;
    private long accountId;
    private LocalDateTime time;

    private String description;

    private long amount;
}

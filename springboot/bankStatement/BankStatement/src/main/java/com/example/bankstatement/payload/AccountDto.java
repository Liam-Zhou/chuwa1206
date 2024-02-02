package com.example.bankstatement.payload;

import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.entity.UserProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex D.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private Long accountID;
    private Long routingNumber;
    private Long accountNumber;
    private UserProfileDto user;
    private Set<TxnDto> txns;

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", accountID='" + accountID + '\'' +
                ", routingNumber='" + routingNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}

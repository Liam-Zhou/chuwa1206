package com.example.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author Alex D.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDtoWithoutUserProfile {
    private Long id;
    private Long accountID;
    private Long routingNumber;
    private Long accountNumber;
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

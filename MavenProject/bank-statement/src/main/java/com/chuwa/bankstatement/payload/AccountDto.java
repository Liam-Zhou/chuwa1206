package com.chuwa.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author xiaorui
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {
    private long id;

    private long userProfileId;

    private String routingNumber;

    private String accountNumber;

}

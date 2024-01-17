package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.entity.Transaction;
import com.chuwa.bankstatement.entity.User;
import com.chuwa.bankstatement.validationgroup.Create;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;
    @NotNull(groups = Create.class)
    private String routingNumber;
    @NotNull(groups = Create.class)
    private String accountNumber;
    private LocalDateTime createDateTime;
    private Set<TransactionDto> transactions;

}

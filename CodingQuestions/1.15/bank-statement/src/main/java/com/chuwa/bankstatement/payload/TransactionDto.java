package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.validationgroup.Create;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    @NotNull(groups = Create.class)
    private Long amount;
    @NotNull(groups = Create.class)
    private String description;
    private LocalDateTime createDateTime;
    private String accountNumber;

}

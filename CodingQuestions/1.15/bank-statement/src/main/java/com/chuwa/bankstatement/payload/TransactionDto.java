package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.validationgroup.Create;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionDto {

    private Long id;
    @NotNull(groups = Create.class)
    private Long amount;
    @NotNull(groups = Create.class)
    private String description;
    private LocalDateTime createDateTime;
    private String accountNumber;

}

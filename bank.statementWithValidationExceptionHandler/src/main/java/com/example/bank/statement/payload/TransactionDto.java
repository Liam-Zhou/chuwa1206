package com.example.bank.statement.payload;

import com.example.bank.statement.entity.Account;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    @NotEmpty
    @Size(min = 8, message = "Account number should be at least 8 characters")
    private Long accountId;
    private String date;
    private String description;
    @NotEmpty
    private Double amount;
}

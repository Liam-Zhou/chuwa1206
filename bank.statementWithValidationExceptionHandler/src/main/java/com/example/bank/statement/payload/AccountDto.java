package com.example.bank.statement.payload;

import com.example.bank.statement.entity.UserProfile;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    @NotEmpty
    private Long userProfileId;
    @NotEmpty
    @Size(min = 8, message = "Routing number should be at least 8 characters")
    private String routingNumber;
    @NotEmpty
    @Size(min = 8, message = "Account number should be at least 8 characters")
    private String accountNumber;
}

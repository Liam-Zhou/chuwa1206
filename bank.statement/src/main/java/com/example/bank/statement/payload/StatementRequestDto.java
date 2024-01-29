package com.example.bank.statement.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatementRequestDto {
    @NotNull
    private Long id;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String endDate;
}

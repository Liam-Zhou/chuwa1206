package com.chuwa.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementDto {

    private String name;
    private String address;
    private Month month;
    private String accountNumber;
    private List<TransactionDto> transactions;

}

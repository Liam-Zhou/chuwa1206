package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.AccountDto;
import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.AccountService;
import com.chuwa.transaction.service.TransactionService;
import com.chuwa.transaction.service.UserProfileService;
import com.chuwa.transaction.vo.BankStatementVo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/bankstatement")
public class BankStatementController {
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final UserProfileService userProfileService;

    public BankStatementController(AccountService accountService, TransactionService transactionService, UserProfileService userProfileService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<BankStatementDto> createBankStatement(@RequestBody @Valid BankStatementVo bankStatementVo) {
        int monthNumber = Integer.parseInt(bankStatementVo.getMonth());
        // Get the first day of the month
        LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0);

        // Get the last day of the month
        LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0)
                .with(TemporalAdjusters.lastDayOfMonth())
                .withHour(23)
                .withMinute(59)
                .withSecond(59);

        List<AccountDto> accounts = this.accountService.findAccountsByUserId(bankStatementVo.getUserId());
        UserProfileDto user = this.userProfileService.getUserProfileById(bankStatementVo.getUserId());

        HashMap<String, List<TransactionDto>> data = new HashMap<>();


        for (AccountDto accountDto : accounts) {

            List<TransactionDto> transactionsFromAccount = this.transactionService.getTransactionByAccountIdAndTimeRange(accountDto.getAccountId(), firstDayOfMonth, lastDayOfMonth);

            data.put(accountDto.getAccountNumber(), transactionsFromAccount);
        }

        BankStatementDto bankStatementDto = new BankStatementDto();
        bankStatementDto.setUsername(user.getName());
        bankStatementDto.setAddress(user.getAddress());
        bankStatementDto.setStatePeriod(firstDayOfMonth.toString() + "-" + lastDayOfMonth.toString());
        bankStatementDto.setData(data);


        return ResponseEntity.ok(bankStatementDto);
    }
}

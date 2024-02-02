package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.payload.AccountDto;
import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.AccountService;
import com.chuwa.transaction.service.BankstatementService;
import com.chuwa.transaction.service.TransactionService;
import com.chuwa.transaction.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
@Service
public class Bankstatementimpl implements BankstatementService {
    private final AccountService accountService;
    private final UserProfileService userProfileService;
    private final TransactionService transactionService;

    public Bankstatementimpl(AccountService accountService, UserProfileService userProfileService, TransactionService transactionService) {
        this.accountService = accountService;
        this.userProfileService = userProfileService;
        this.transactionService = transactionService;
    }

    @Override
    public BankStatementDto createBankstatement(long userId, String month) {
        int monthNumber = Integer.parseInt(month);
        // Get the first day of the month
        LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0);

        // Get the last day of the month
        LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0)
                .with(TemporalAdjusters.lastDayOfMonth())
                .withHour(23)
                .withMinute(59)
                .withSecond(59);

        List<AccountDto> accounts = this.accountService.findAccountsByUserId(userId);
        UserProfileDto user = this.userProfileService.getUserProfileById(userId);

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
        return bankStatementDto;
    }
}

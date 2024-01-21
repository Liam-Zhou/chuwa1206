package org.chuwa.bankstatement.controller;

import jakarta.validation.Valid;
import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;
import org.chuwa.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> postAccount(@Valid @RequestBody AccountDto accountDto) {
        AccountDto account = accountService.CreateAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/bs")
    public ResponseEntity<BankStatement> getBankStatement(
            @RequestParam(name="userid", defaultValue = "1") Long userId,
            @RequestParam(name="start", defaultValue = "1") Integer start,
            @RequestParam(name="end", defaultValue = "10") Integer end) {
        BankStatement response = accountService.getStatement(userId, start, end);
        response.setPeriodStartMonth(start);
        response.setPeriodEndMonth(end);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

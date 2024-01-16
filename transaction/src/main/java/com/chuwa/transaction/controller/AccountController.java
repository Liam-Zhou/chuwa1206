package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.AccountDto;
import com.chuwa.transaction.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccounts(@RequestBody AccountDto accountDto) {
        AccountDto response = this.accountService.createAccount(accountDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AccountDto>> findAccountsByUserProfileId(@PathVariable(name="id") long userId) {
        List<AccountDto> accounts = this.accountService.findAccountsByUserId(userId);

        return ResponseEntity.ok(accounts);
    }


}

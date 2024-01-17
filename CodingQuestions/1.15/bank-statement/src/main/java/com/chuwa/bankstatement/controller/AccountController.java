package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.service.AccountService;
import com.chuwa.bankstatement.validationgroup.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{user-id}/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@PathVariable(name = "user-id") Long userId,
                                                    @Validated(Create.class) @RequestBody AccountDto accountDto) {
        AccountDto response = accountService.createAccount(userId, accountDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

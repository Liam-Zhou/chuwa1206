package com.chuwa.learn.statement.controller;

import com.chuwa.learn.statement.payload.AccountDto;
import com.chuwa.learn.statement.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
        AccountDto res = this.accountService.createAccount(accountDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AccountDto> getAccount(@PathVariable long id) {
        return ResponseEntity.ok(this.accountService.getAccountById(id));
    }


}

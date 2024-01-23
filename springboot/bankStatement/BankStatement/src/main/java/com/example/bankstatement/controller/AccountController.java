package com.example.bankstatement.controller;

import com.example.bankstatement.entity.Account;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.UserProfileDto;
import com.example.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/users/{userId}/accounts")
    public ResponseEntity<AccountDto> createAccount(@PathVariable(value="userId") long userId,  @RequestBody AccountDto accountDto){
        AccountDto response = accountService.createAccount(userId, accountDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}

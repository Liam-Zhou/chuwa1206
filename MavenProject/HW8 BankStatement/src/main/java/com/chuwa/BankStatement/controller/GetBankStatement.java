package com.chuwa.BankStatement.controller;

import com.chuwa.BankStatement.payload.AccountRequest;
import com.chuwa.BankStatement.payload.BankStatement;
import com.chuwa.BankStatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/bankstatement", method = RequestMethod.POST)
@RestController
public class GetBankStatement {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> getAccountDetails(@RequestBody AccountRequest accountRequest) {
        BankStatement response = accountService.getAccountDetails(accountRequest.getUserId(), accountRequest.getMonth());
        return ResponseEntity.ok(response);
    }
}

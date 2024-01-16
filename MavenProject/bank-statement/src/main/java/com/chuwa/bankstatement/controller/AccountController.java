package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.dao.AccountRepository;
import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorui
 */
@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto response = accountService.createAccount(accountDto);

        return ResponseEntity.ok(response);
    }
}

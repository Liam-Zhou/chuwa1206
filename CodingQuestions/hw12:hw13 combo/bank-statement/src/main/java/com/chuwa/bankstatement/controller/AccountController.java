package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.AccountDto;
import com.chuwa.bankstatement.service.AccountService;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(accountService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto, HttpServletResponse response) {
        AccountDto createdAccount = accountService.createAccount(accountDto);

        // Create a new cookie
        Cookie cookie = new Cookie("accountInfo", "someValue"); // set the name and value of the cookie
        cookie.setPath("/");
        cookie.setHttpOnly(true); // Optional: Marks the cookie as HttpOnly
        cookie.setMaxAge(7 * 24 * 60 * 60); // Optional: Sets the cookie to expire after one week

        // Add the cookie to the response
        response.addCookie(cookie);

        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

}

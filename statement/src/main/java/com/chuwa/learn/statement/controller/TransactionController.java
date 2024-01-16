package com.chuwa.learn.statement.controller;

import com.chuwa.learn.statement.payload.AccountDto;
import com.chuwa.learn.statement.payload.StatementsDto;
import com.chuwa.learn.statement.payload.TransactionDto;
import com.chuwa.learn.statement.payload.UserDto;
import com.chuwa.learn.statement.service.AccountService;
import com.chuwa.learn.statement.service.TransactionService;
import com.chuwa.learn.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto res = this.transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<StatementsDto> getStatement(@RequestParam long id, @RequestParam String StartDate, @RequestParam String endDate){
        StatementsDto res = new StatementsDto();
        UserDto userDto = userService.getUserById(accountService.getAccountById(id).getUserId());
        res.setAddr(userDto.getAddr());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        res.setStartDate(LocalDateTime.parse(StartDate,formatter));
        res.setEndDate(LocalDateTime.parse(endDate,formatter));
        res.setAccountDto(accountService.getAccountById(id));
        res.setTransactions(transactionService.getTransactions(id,LocalDateTime.parse(StartDate,formatter),LocalDateTime.parse(endDate,formatter)));
        res.setUserName(userDto.getName());
        return ResponseEntity.ok(res);
    }

}

package com.example.redbook.controller;


import com.example.redbook.payload.UserTransactionDto;
import com.example.redbook.service.TransactionService;
import com.example.redbook.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//@Tag(name = "Transaction", description = "CRUD REST AIPs for Transaction resources")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

//    @ApiOperation(value = "Seach Transaction REST API")
    @GetMapping("{userId}/transactions")
    public ResponseEntity<UserTransactionDto> getTransactionsById(
            @PathVariable(value = "userId") Long userId,
            @RequestParam(value = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam(value = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {

        return ResponseEntity.ok(transactionService.getUserTransactions(userId, from, to));
    }
}

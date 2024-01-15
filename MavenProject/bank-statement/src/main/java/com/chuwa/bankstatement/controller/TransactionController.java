package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
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
@RequestMapping("api/v1/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto response = transactionService.createTransaction(transactionDto);

        return ResponseEntity.ok(response);
    }
}

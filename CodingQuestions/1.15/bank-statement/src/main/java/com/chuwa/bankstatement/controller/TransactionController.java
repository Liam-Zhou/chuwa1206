package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
import com.chuwa.bankstatement.validationgroup.Create;
import com.chuwa.bankstatement.validationgroup.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestParam(name = "user-id") Long userId,
                                                            @RequestParam(name = "account-id") Long accountId,
                                                            @Validated(Create.class) @RequestBody TransactionDto transactionDto) {
        TransactionDto response = transactionService.createTransaction(userId, accountId, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable(name = "id") Long transactionId,
                                                            @Validated(Update.class) @RequestBody TransactionDto transactionDto) {
        TransactionDto response = transactionService.updateTransaction(transactionId, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") Long transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable(name = "id") Long transactionId) {
        transactionService.deleteTransactionById(transactionId);
        return new ResponseEntity<>("Transaction Deleted Successfully", HttpStatus.OK);
    }
}

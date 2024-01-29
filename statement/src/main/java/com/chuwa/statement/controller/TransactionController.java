package com.chuwa.statement.controller;


import com.chuwa.statement.payload.TransactionDto;
import com.chuwa.statement.service.inter.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chuwa/statement/transaction")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.createTransaction(transactionDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> findAllTransaction(){
        return ResponseEntity.ok(transactionService.findAllTransaction());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> findTransactionById(@PathVariable long id){
        return ResponseEntity.ok(transactionService.findTransactionById(id));
    }


}

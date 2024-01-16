package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){
        TransactionDto response = transactionService.createTransaction(transactionDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable(name = "id") long id){
        TransactionDto response = transactionService.getTransactionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getTransactionsByUserAndDateRange(@RequestParam long userId,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<TransactionDto> response = transactionService.getTransactionsByUserAndDateRange(userId, startDate, endDate);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getTransactionByAccountAndDateRange(@RequestParam long accountId,
                                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<TransactionDto> response = transactionService.getTransactionByAccountAndDateRange(accountId, startDate, endDate);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(@RequestBody TransactionDto transactionDto,@PathVariable(name = "id") long id){
        TransactionDto response = transactionService.updateTransaction(transactionDto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable(name = "id") long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}

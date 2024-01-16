package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto transaction = this.transactionService.createTransaction(transactionDto);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionDto>> findTransactionsByAccountIdAndRange
            (@PathVariable long id, @RequestParam String from, @RequestParam String to){
        System.out.println(from);
        System.out.println(to);
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIDNIGHT);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MIDNIGHT).plusDays(1);
        return ResponseEntity.ok(this.transactionService.getTransactionByAccountIdAndTimeRange(id, startDateTime, endDateTime));
    }
}

package com.example.bank.statement.controller;

import com.example.bank.statement.payload.TransactionResponse;
import com.example.bank.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/statement")
public class StatementController {
    @Autowired
    private StatementService statementService;

    @GetMapping
    public ResponseEntity<TransactionResponse> getStatement(@RequestParam("user_id") long userId, @RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        return new ResponseEntity<>(this.statementService.getStatement(userId, startDate, endDate), HttpStatus.OK);
    }
}

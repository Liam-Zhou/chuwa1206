package com.chuwa.bankstatement.controller;

import com.chuwa.bankstatement.payload.BankStatementRequestDto;
import com.chuwa.bankstatement.payload.BankStatementResponseDto;
import com.chuwa.bankstatement.service.BankStatementService;
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
@RequestMapping("api/v1/bank-statement")
public class BankStatementController {
    @Autowired
    private BankStatementService bankStatementService;

    @PostMapping
    public ResponseEntity<BankStatementResponseDto> getBankStatement(@RequestBody BankStatementRequestDto request) {
        BankStatementResponseDto response = this.bankStatementService.getBankStatement(request);

        return ResponseEntity.ok(response);
    }
}

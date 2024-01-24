package org.chuwa.bankstatement.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import jakarta.validation.Valid;
import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;
import org.chuwa.bankstatement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> postAccount(@Valid @RequestBody AccountDto accountDto) {
        AccountDto account = accountService.CreateAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/bs")
    public ResponseEntity<BankStatement> getBankStatement(
            @RequestParam(name="userid", defaultValue = "1") Long userId,
            @RequestParam(name="start", defaultValue = "1") Integer start,
            @RequestParam(name="end", defaultValue = "10") Integer end) {
        BankStatement response = accountService.getStatement(userId, start, end);
        response.setPeriodStartMonth(start);
        response.setPeriodEndMonth(end);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping(value="/bspdf", produces= MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getBankStatementPdf(
            @RequestParam(name="userid", defaultValue = "1") Long userId,
            @RequestParam(name="start", defaultValue = "1") Integer start,
            @RequestParam(name="end", defaultValue = "10") Integer end) throws DocumentException, FileNotFoundException {
        BankStatement response = accountService.getStatement(userId, start, end);
        response.setPeriodStartMonth(start);
        response.setPeriodEndMonth(end);
        ByteArrayOutputStream pdfStream = accountService.generateStatementPdf(response);
        return new ResponseEntity<>(pdfStream.toByteArray(), HttpStatus.OK);
    }
}

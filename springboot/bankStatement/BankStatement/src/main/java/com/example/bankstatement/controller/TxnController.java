package com.example.bankstatement.controller;

import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.service.ReportService;
import com.example.bankstatement.service.TxnService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Alex D.
 */
@RestController
@RequestMapping("/api/v1")
public class TxnController {
    @Autowired
    private TxnService txnService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/accounts/{accountId}/txns")
    public ResponseEntity<TxnDto> createTxn(@PathVariable(value = "accountId") Long accountId, @RequestBody TxnDto txnDto){
        TxnDto response = txnService.createTxn(accountId, txnDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/accounts/{accountId}/txns/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getTransactionsReport(@PathVariable(value = "accountId") Long accountId,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) throws DocumentException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime startDate1 = LocalDateTime.parse(startDate, formatter);
//        LocalDateTime endDate1 = LocalDateTime.parse(endDate, formatter);
        List<TxnDto> transactions = txnService.getTxnsByAccountIdAndDateRange(accountId, startDate, endDate);
        byte[] pdfContent = reportService.generatePdfReport(transactions);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("transaction_report.pdf").build());

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }

}

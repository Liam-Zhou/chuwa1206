package com.example.bankstatement.controller;

import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.payload.TxnResponsePageable;
import com.example.bankstatement.service.ReportService;
import com.example.bankstatement.service.TxnService;
import com.example.bankstatement.util.AppConstants;
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
@RequestMapping("/api/v1/users/{userId}/accounts/{accountId}")
public class TxnController {
    @Autowired
    private TxnService txnService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/txns")
    public ResponseEntity<TxnDto> createTxn(@PathVariable(value = "accountId") Long accountId, @RequestBody TxnDto txnDto){
        TxnDto response = txnService.createTxn(accountId, txnDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/txns")
    public ResponseEntity<List<TxnDto>> getTxnsByAccountIdAndDateRange(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "accountId") Long accountId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return new ResponseEntity<>(txnService.getTxnsByAccountIdAndDateRange(accountId, startDate, endDate),HttpStatus.OK);
    }

    @GetMapping("/txns-pageable")
    public TxnResponsePageable getAllTxnByAccountId(@PathVariable(value = "userId") Long userId,
                                                    @PathVariable(value = "accountId") Long accountId,
                                                    @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir){
        return txnService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    /**
     * How to verify Authentication? userId == this user
     * or do we send userId with other method? like session / JWT etc.
     * Where do we verify? in the controller?
     * @param userId
     * @param accountId
     * @param txnId
     * @return
     */
    @GetMapping("/txns/{txnId}")
    public ResponseEntity<TxnDto> getTxnByTxnId(@PathVariable(value = "userId") Long userId,
                                                         @PathVariable(value = "accountId") Long accountId,
                                                         @PathVariable(value = "txnId") Long txnId){
        return new ResponseEntity<>(txnService.getTxnByTxnId(txnId), HttpStatus.OK);
    }


    /**
     * Generate Txns report by accountId by DateRange.
     * @param accountId
     * @param startDate
     * @param endDate
     * @return
     * @throws DocumentException
     */
    @GetMapping(value = "/txns/report", produces = MediaType.APPLICATION_PDF_VALUE)
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

    @PutMapping("/txns/{txnId}")
    public ResponseEntity<TxnDto> updateTxnByTxnId(@PathVariable(value = "userId") Long userId,
                                                   @PathVariable(value = "accountId") Long accountId,
                                                   @PathVariable(value = "txnId") Long txnId,
                                                   @RequestBody TxnDto txnDto){
        return new ResponseEntity<>(txnService.updateTxnByTxnId(txnId, txnDto),HttpStatus.OK);
    }

    @DeleteMapping("/txns/{txnId}")
    public ResponseEntity<String> deleteTxnByTxnId(@PathVariable(value = "userId") Long userId,
                                                   @PathVariable(value = "accountId") Long accountId,
                                                   @PathVariable(value = "txnId") Long txnId){
        txnService.deleteTxnByTxnId(txnId);
        return new ResponseEntity<>("The txn deleted successfully.",HttpStatus.OK);
    }

}

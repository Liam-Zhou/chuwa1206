package com.example.bank.statement.controller;

import com.example.bank.statement.payload.StatementRequestDto;
import com.example.bank.statement.payload.TransactionResponse;
import com.example.bank.statement.service.StatementService;
import com.example.bank.statement.util.StatementServiceUtil;
import com.itextpdf.text.DocumentException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;




@RestController
@RequestMapping("/api/v1/statement")
public class StatementController {
    @Autowired
    private StatementService statementService;


    private static final Logger logger = LoggerFactory.getLogger(StatementController.class);

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getStatementByIdAndPeriod(@RequestParam("user_id") long userId,
                                               @RequestParam("start_date") String startDate,
                                               @RequestParam("end_date") String endDate) throws DocumentException {
        TransactionResponse transactionResponse = statementService.getStatement(userId, startDate, endDate);

        // Generate PDF content from the TransactionResponse
        logger.info("Start transforming to pdf, userId is: {}, startDate is: {}, endDate is: {}", userId, startDate, endDate);
        byte[] pdfContent = StatementServiceUtil.generatePdfContent(transactionResponse);

        logger.info("Finish transforming to pdf");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
        //return new ResponseEntity<>(this.statementService.getStatement(userId, startDate, endDate), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_PDF_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> getStatementByIdAndPeriodRequestBody(@Valid @RequestBody StatementRequestDto statementRequestDto) throws DocumentException {
        TransactionResponse transactionResponse = statementService.getStatement(statementRequestDto.getId(),
                statementRequestDto.getStartDate(), statementRequestDto.getEndDate());

        // Generate PDF content from the TransactionResponse
        logger.info("Start transforming to pdf, StatementRequestDto is: {}", statementRequestDto);
        byte[] pdfContent = StatementServiceUtil.generatePdfContent(transactionResponse);

        logger.info("Finish transforming to pdf");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
        //return new ResponseEntity<>(this.statementService.getStatement(userId, startDate, endDate), HttpStatus.OK);
    }
}

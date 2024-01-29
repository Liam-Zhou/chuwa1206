package com.chuwa.statement.controller;

import com.chuwa.statement.exception.ResourceNotFoundException;
import com.chuwa.statement.payload.ErrorDetails;
import com.chuwa.statement.payload.StatementDto;
import com.chuwa.statement.payload.StatementRequestDto;
import com.chuwa.statement.service.inter.StatementService;
import com.chuwa.statement.util.StatementUtil;
import com.itextpdf.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chuwa/statement")
public class StatementController {
    private StatementService statementService;
    private static final Logger logger= LoggerFactory.getLogger(StatementController.class);

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @PostMapping(produces= MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> findStatementByUserIdAndDateBetween(@RequestBody StatementRequestDto statementRequestDto) throws DocumentException {
        List<StatementDto> statementDtos=statementService.findStatementByUserIdAndDateBetween(
                statementRequestDto.getUserId(),statementRequestDto.getStartDate(),statementRequestDto.getEndDate()
        );
        logger.info("Statements: {}",statementDtos);
        logger.info("Start transforming to pdf...");
        byte[] pdfContent= StatementUtil.generatePdfContent(statementDtos);
        logger.info("Finish pdf generation!");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfContent);
    }

    @GetMapping
    public ResponseEntity<List<StatementDto>> findStatementByUserIdAndDateBetweenRequestParam(
            @RequestParam("userId") long userId,
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate
            ){
        return ResponseEntity.ok(statementService.findStatementByUserIdAndDateBetween(
                userId, startDate, endDate
        ));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> HandleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorDetails(
                        new Date(),
                        exception.getMessage(),
                        webRequest.getDescription(true)
                ),
                HttpStatus.NOT_FOUND
        );
    }

}

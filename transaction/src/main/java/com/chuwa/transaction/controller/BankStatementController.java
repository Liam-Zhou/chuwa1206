package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.service.BankstatementService;
import com.chuwa.transaction.service.PdfService;
import com.chuwa.transaction.vo.BankStatementVo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/bankstatement")
public class BankStatementController {
    private static final Logger logger = LoggerFactory.getLogger(BankStatementController.class);
    private final BankstatementService bankstatementService;
    private final PdfService pdfService;

    public BankStatementController(BankstatementService bankstatementService, PdfService pdfService) {
        this.bankstatementService = bankstatementService;
        this.pdfService = pdfService;
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<BankStatementDto> createBankStatement(@RequestBody @Valid BankStatementVo bankStatementVo) {

        BankStatementDto bankStatementDto = bankstatementService.createBankstatement(bankStatementVo.getUserId(),bankStatementVo.getMonth());

        return ResponseEntity.ok(bankStatementDto);
    }

    @PostMapping(value = "/pdf/generate", produces = MediaType.APPLICATION_PDF_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> generatePDF(@RequestBody @Valid BankStatementVo bankStatementVo) {
        try {
            logger.info("Request received to generate PDF for BankStatement: {}", bankStatementVo);

            // Create BankStatementDto
            BankStatementDto bankStatementDto = bankstatementService.createBankstatement(bankStatementVo.getUserId(), bankStatementVo.getMonth());

            // Generate PDF
            logger.info("Generating PDF for BankStatement: {}", bankStatementDto);
            byte[] pdf = this.pdfService.generatePdf(bankStatementDto, bankStatementVo);
            logger.info("PDF generation completed for BankStatement: {}", bankStatementDto);

            return ResponseEntity.ok().body(pdf);
        } catch (Exception e) {
            logger.error("Error generating PDF for BankStatement: {}", bankStatementVo, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}

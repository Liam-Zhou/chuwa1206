package com.chuwa.transaction.controller;

import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.service.BankstatementService;
import com.chuwa.transaction.service.PdfService;
import com.chuwa.transaction.vo.BankStatementVo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("api/v1/bankstatement")
public class BankStatementController {
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

    @PostMapping("/pdf/generate")
    public void generatePDF(@RequestBody @Valid BankStatementVo bankStatementVo, HttpServletResponse response) {
        BankStatementDto bankStatementDto = bankstatementService.createBankstatement(bankStatementVo.getUserId(),bankStatementVo.getMonth());
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        this.pdfService.generatePdf(bankStatementDto,bankStatementVo, response);


    }

}

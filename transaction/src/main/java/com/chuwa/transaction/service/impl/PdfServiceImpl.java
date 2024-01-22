package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.service.PdfService;
import com.chuwa.transaction.vo.BankStatementVo;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfServiceImpl implements PdfService {
    @Override
    public void generatePdf(BankStatementDto bankStatementDto, BankStatementVo bankStatementVo, HttpServletResponse response) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontTitle.setSize(18);

            // add user information
            document.add(new Paragraph(bankStatementVo.getMonth() + " Statement", fontTitle));
            document.add(new Paragraph(bankStatementDto.getUsername()));
            document.add(new Paragraph("Address: " + bankStatementDto.getAddress()));
            document.add(new Paragraph("State Period: " + bankStatementDto.getStatePeriod()));
            document.add(new Paragraph("\n"));

            // add transaction data
            HashMap<String, List<TransactionDto>> data = bankStatementDto.getData();
            for (Map.Entry<String, List<TransactionDto>> entry : data.entrySet()) {
                String key = entry.getKey();
                List<TransactionDto> transactionList = entry.getValue();

                document.add(new Paragraph("Key: " + key));

                for (TransactionDto transaction : transactionList) {
                    document.add(new Paragraph("Transaction ID: " + transaction.getTransactionId()));
                    document.add(new Paragraph("Description: " + transaction.getDescription()));
                    document.add(new Paragraph("Amount: " + transaction.getAmount()));
                    document.add(new Paragraph("Create Date Time: " + transaction.getCreateDateTime()));
                    document.add(new Paragraph("\n"));
                }
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

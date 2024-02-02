package com.chuwa.bankstatement.service.impl;

import com.chuwa.bankstatement.payload.StatementDto;
import com.chuwa.bankstatement.payload.TransactionDto;
import com.chuwa.bankstatement.service.PdfGenerationService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.util.List;
import com.itextpdf.layout.element.ListItem;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


@Service
public class PdfGenerationServiceImpl implements PdfGenerationService {

    public ByteArrayInputStream generateStatementsPdf(List<StatementDto> statements) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        for (StatementDto statement : statements) {
            document.add(new Paragraph("Name: " + statement.getName()));
            document.add(new Paragraph("Address: " + statement.getAddress()));
            document.add(new Paragraph("Month: " + statement.getMonth()));
            document.add(new Paragraph("Account Number: " + statement.getAccountNumber()));

            com.itextpdf.layout.element.List transactionsList = new com.itextpdf.layout.element.List();
            for (TransactionDto transaction : statement.getTransactions()) {
                transactionsList.add(new ListItem(transaction.toString())); // Implement toString in TransactionDto if needed
            }
            document.add(transactionsList);
            document.add(new Paragraph("\n")); // Add a blank line between statements
        }
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}

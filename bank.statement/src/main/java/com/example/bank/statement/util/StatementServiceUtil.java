package com.example.bank.statement.util;

import com.example.bank.statement.payload.TransactionDto;
import com.example.bank.statement.payload.TransactionResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class StatementServiceUtil {
    public static byte[] generatePdfContent(TransactionResponse transactionResponse) throws DocumentException{
            // Create a Document
            Document document = new Document();
            // Create a ByteArrayOutputStream to write PDF content
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, outputStream);
            // Open the Document for writing
            document.open();
            // Add content to the Document
            addContentToDocument(document, transactionResponse);

            document.close();
            return outputStream.toByteArray();
    }

    private static void addContentToDocument(Document document, TransactionResponse transactionResponse) throws DocumentException {
        // Add content from TransactionResponse to the Document
        document.add(new Paragraph("Username: " + transactionResponse.getUsername()));
        document.add(new Paragraph("Address: " + transactionResponse.getAddr()));
        document.add(new Paragraph("Statement Period: " + transactionResponse.getStatePeriod()));
        document.add(new Paragraph("Account: " + transactionResponse.getAccount()));

        // Add transactions
        List<TransactionDto> transactions = transactionResponse.getTxn();
        for (TransactionDto transaction : transactions) {
            document.add(new Paragraph("Transaction: " + transaction.getDescription()));
            document.add(new Paragraph("Amount: " + transaction.getAmount()));
            document.add(new Paragraph("Date: " + transaction.getDate()));
            document.add(new Paragraph("------------"));
        }
    }
}

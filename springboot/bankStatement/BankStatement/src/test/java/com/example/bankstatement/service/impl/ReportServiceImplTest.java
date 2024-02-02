package com.example.bankstatement.service.impl;

import com.example.bankstatement.payload.TxnDto;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alex D.
 */
class ReportServiceImplTest {

    private ReportServiceImpl reportService = new ReportServiceImpl();

    @Test
    public void testGeneratePdfReport() throws Exception {
        List<TxnDto> transactions = Arrays.asList(
                new TxnDto(1L, LocalDateTime.now(),"abc",1L),
                new TxnDto(1L, LocalDateTime.now(),"abc",1L)
        );

        byte[] pdfContent = null;
        try {
            pdfContent = reportService.generatePdfReport(transactions);
        } catch (Exception e) {
            fail("Exception thrown during PDF generation: " + e.getMessage());
        }

        assertNotNull(pdfContent);
        assertTrue(pdfContent.length > 0);

        /**
         * OK: add integration test
         */
        try (PDDocument document = PDDocument.load(new ByteArrayInputStream(pdfContent))) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            // Perform assertions on the extracted text
            assertTrue(text.contains("Transactions Report"));
            // More assertions based on the expected content
        } catch (IOException e) {
            fail("Exception thrown during PDF parsing: " + e.getMessage());
        }

    }
}
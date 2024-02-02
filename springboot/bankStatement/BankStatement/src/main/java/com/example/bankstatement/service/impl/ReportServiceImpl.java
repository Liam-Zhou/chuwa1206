package com.example.bankstatement.service.impl;

import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.service.ReportService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex D.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public byte[] generatePdfReport(List<TxnDto> transactions) throws DocumentException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        Chunk chunk = new Chunk("Transactions Report", font);

        document.add(chunk);

        for (TxnDto transaction : transactions) {
            Paragraph para = new Paragraph(transaction.toString(), font);
            document.add(para);
        }

        document.close();
        return out.toByteArray();
    }
}

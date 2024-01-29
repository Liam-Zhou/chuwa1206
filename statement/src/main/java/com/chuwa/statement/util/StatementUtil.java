package com.chuwa.statement.util;

import com.chuwa.statement.payload.StatementDto;
import com.chuwa.statement.payload.TransactionDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class StatementUtil {
    public static byte[] generatePdfContent(List<StatementDto> statementDtos) throws DocumentException {
        Document document=new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        addContentToDocument(document, statementDtos);
        document.close();
        return outputStream.toByteArray();
    }

    public static void addContentToDocument(Document document, List<StatementDto> statementDtos) throws DocumentException {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
        statementDtos.stream()
                .forEach(
                        statementDto -> {
                            try {
                                document.add(new Paragraph("userName: "+statementDto.getUserName()));
                                document.add(new Paragraph("userAddress: "+statementDto.getUserAddress()));
                                document.add(new Paragraph("startDate: "+statementDto.getStartDate()));
                                document.add(new Paragraph("endDate: "+statementDto.getEndDate()));
                                document.add(new Paragraph("accountNumber: "+statementDto.getAccountNumber()));
                                List<TransactionDto> transactionDtos=statementDto.getTxns();
                                document.add(new Paragraph("####### Txn #######"));
                                for(TransactionDto txn:transactionDtos){
                                    document.add(new Paragraph("accountId: "+txn.getAccountId()));
                                    document.add(new Paragraph("date: "+txn.getDate()));
                                    document.add(new Paragraph("amount: "+txn.getAmount()));
                                }
                                document.add(new Paragraph("----------------------",font));
                            } catch (DocumentException e) {
                                throw new RuntimeException(e);
                            }

                        }
                );
    }
}

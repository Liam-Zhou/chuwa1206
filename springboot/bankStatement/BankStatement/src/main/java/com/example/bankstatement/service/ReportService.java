package com.example.bankstatement.service;

import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.payload.TxnDto;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex D.
 */
public interface ReportService {
    byte[] generatePdfReport(List<TxnDto> transactions) throws DocumentException;
}

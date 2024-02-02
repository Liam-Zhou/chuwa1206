package com.chuwa.bankstatement.service;

import com.chuwa.bankstatement.payload.StatementDto;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface PdfGenerationService {
    ByteArrayInputStream generateStatementsPdf(List<StatementDto> statements);
}

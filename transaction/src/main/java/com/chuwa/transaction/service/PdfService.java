package com.chuwa.transaction.service;

import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.vo.BankStatementVo;
import jakarta.servlet.http.HttpServletResponse;

public interface PdfService {
    byte[] generatePdf(BankStatementDto bankStatementDto, BankStatementVo bankStatementVo);
}

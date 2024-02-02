package org.chuwa.bankstatement.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public interface AccountService {
    AccountDto CreateAccount(AccountDto accountDto);

    BankStatement getStatement(Long userId, Integer startMonth, Integer endMonth);

    ByteArrayOutputStream generateStatementPdf(BankStatement statement) throws DocumentException;
}

package org.chuwa.bankstatement.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.chuwa.bankstatement.dao.AccountRepository;
import org.chuwa.bankstatement.dao.TxnRepository;
import org.chuwa.bankstatement.dao.UserRepository;
import org.chuwa.bankstatement.entities.Account;
import org.chuwa.bankstatement.entities.Txn;
import org.chuwa.bankstatement.entities.User;
import org.chuwa.bankstatement.exceptions.ResourceNotFoundException;
import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;
import org.chuwa.bankstatement.payload.TxnDto;
import org.chuwa.bankstatement.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TxnRepository txnRepository;

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Override
    public AccountDto CreateAccount(AccountDto accountDto) {
        Account toBeSaved = convertFromDtoToEntity(accountDto);
        Account saved = this.accountRepository.save(toBeSaved);
        return convertFromEntityToDto(saved);
    }

    @Override
    public BankStatement getStatement(Long userId, Integer startMonth, Integer endMonth) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "User not Found", userId)
        );
        Account account = Optional.ofNullable(user.getAccount()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "Account not Found with User", userId)
        );
        List<TxnDto> txns = txnRepository.findAllByAccountAndDateBetween(account, startMonth, endMonth).stream()
                .map(this::convertFromTxntoTxnDto).collect(Collectors.toList());
        return new BankStatement(user.getName(), user.getAddr(), account.getAccountNumber(), txns);
    }

    @Override
    public ByteArrayOutputStream generateStatementPdf(BankStatement statement) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            // Create paragraphs for each piece of information
            Paragraph usernameParagraph = new Paragraph("username: " + statement.getUsername(), font);
            Paragraph accountIdParagraph = new Paragraph("account id: " + statement.getAccountId(), font);
            Paragraph addrParagraph = new Paragraph("address: " + statement.getAddr(), font);
            Paragraph startMonthParagraph = new Paragraph("start month: " + statement.getPeriodStartMonth().toString(), font);
            Paragraph endMonthParagraph = new Paragraph("end month: " + statement.getPeriodEndMonth().toString(), font);
            Paragraph transactionsParagraph = new Paragraph("transactions: " + statement.getTransactions().toString(), font);
            // Add paragraphs to the document
            document.add(usernameParagraph);
            document.add(accountIdParagraph);
            document.add(addrParagraph);
            document.add(startMonthParagraph);
            document.add(endMonthParagraph);
            document.add(transactionsParagraph);
            logger.info("statement pdf created");
        } finally {
            if (document.isOpen()) {
                document.close();
                logger.debug("make sure document is closed");
            }
        }
        return outputStream;
    }

    private TxnDto convertFromTxntoTxnDto(Txn saved) {
        TxnDto txnDto = new TxnDto();
        txnDto.setTxnId(saved.getTxnId());
        txnDto.setAccountId(saved.getAccount().getAccId());
        txnDto.setAmount(saved.getAmount());
        txnDto.setDesc(saved.getDesc());
        txnDto.setDate(saved.getDate());
        return txnDto;
    }

    private AccountDto convertFromEntityToDto(Account saved) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(saved.getAccId());
        accountDto.setAccountNumber(saved.getAccountNumber());
        accountDto.setRoutingNumber(saved.getRoutingNumber());
        accountDto.setUserId(saved.getUser().getUserId());
        return accountDto;
    }

    private Account convertFromDtoToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setRoutingNumber(accountDto.getRoutingNumber());
//        account.setAccId(accountDto.getAccountId());
        account.setUser(userRepository.findById(accountDto.getUserId()).orElse(null));
        return account;
    }
}

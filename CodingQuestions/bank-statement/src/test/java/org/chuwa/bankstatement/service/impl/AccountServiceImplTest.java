package org.chuwa.bankstatement.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.chuwa.bankstatement.dao.AccountRepository;
import org.chuwa.bankstatement.dao.TxnRepository;
import org.chuwa.bankstatement.dao.UserRepository;
import org.chuwa.bankstatement.entities.Account;
import org.chuwa.bankstatement.entities.Txn;
import org.chuwa.bankstatement.entities.User;
import org.chuwa.bankstatement.payload.AccountDto;
import org.chuwa.bankstatement.payload.BankStatement;
import org.chuwa.bankstatement.payload.TxnDto;
import org.chuwa.bankstatement.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TxnRepository txnRepository;

    @Mock
    private BankStatement errorBankStatement;

    @InjectMocks
    private AccountServiceImpl accountService;

    private Account account;
    private User user;

    @BeforeEach
    void setUp() {
        logger.info("set up account for each test");
        user = new User(1L, "username", "addr", "phone", "email");
        account = new Account(1L, user, "routingNum", "accNum");
        user.setAccount(account);
    }

    @BeforeAll
    static void beforeAll() { logger.info("start AccountService test..."); }

    @Test
    void createAccount() {
        AccountDto accountDto = new AccountDto(1L, 1L, "routingNum", "accNum");
        when(accountRepository.save(ArgumentMatchers.any(Account.class)))
                .thenReturn(account);
        AccountDto response = accountService.CreateAccount(accountDto);

        // assertions
        assertNotNull(response);
        assertEquals(accountDto.getAccountId(), response.getAccountId());
        assertEquals(accountDto.getUserId(), response.getUserId());
        assertEquals(accountDto.getAccountNumber(), response.getAccountNumber());
        assertEquals(accountDto.getRoutingNumber(), response.getRoutingNumber());
    }

    @Test
    void getStatement() {
        List<Txn> txns = new ArrayList<>();
        Txn testTxn = new Txn();
        testTxn.setAccount(account);
        txns.add(testTxn);
        List<TxnDto> txnDtos = txns.stream()
                .map((txn) -> accountService.convertFromTxntoTxnDto(txn))
                .toList();
        when(userRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(user));
        when(txnRepository.findAllByAccountAndDateBetween(
                ArgumentMatchers.any(Account.class),
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()))
                .thenReturn(txns);
        BankStatement response = accountService.getStatement(1L, 1, 2);
        BankStatement testBS = new BankStatement(user.getName(), user.getAddr(),
                user.getAccount().getAccountNumber(), txnDtos);
        // assertions
        assertNotNull(response);
        assertEquals(testBS.getUsername(), response.getUsername());
        assertEquals(testBS.getAccountId(), response.getAccountId());
        assertEquals(testBS.getAddr(), response.getAddr());
        assertEquals(testBS.getTransactions().size(), response.getTransactions().size());
    }

    @Test
    void generateStatementPdf() throws DocumentException {
        BankStatement testBS = new BankStatement(user.getName(), user.getAddr(),
                user.getAccount().getAccountNumber(), new ArrayList<>());
        testBS.setPeriodStartMonth(1);
        testBS.setPeriodEndMonth(2);
        ByteArrayOutputStream response = accountService.generateStatementPdf(testBS);
        assertNotNull(response);
    }
}
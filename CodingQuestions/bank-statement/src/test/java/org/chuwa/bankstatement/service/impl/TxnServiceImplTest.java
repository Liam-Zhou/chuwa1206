package org.chuwa.bankstatement.service.impl;

import org.chuwa.bankstatement.dao.AccountRepository;
import org.chuwa.bankstatement.dao.TxnRepository;
import org.chuwa.bankstatement.entities.Account;
import org.chuwa.bankstatement.entities.Txn;
import org.chuwa.bankstatement.payload.TxnDto;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TxnServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(TxnServiceImplTest.class);

    @Mock
    private TxnRepository txnRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TxnServiceImpl txnService;

    private Txn transaction;
    private Account account;

    @BeforeEach
    void setUp() {
        logger.info("set up txn for each test");
        transaction = new Txn();
        transaction.setTxnId(1L);
        transaction.setAmount(1);
        transaction.setDesc("test txn");
        transaction.setDate(1);
        account = new Account();
        account.setAccId(2L);
        transaction.setAccount(account);
    }

    @BeforeAll
    static void beforeAll() { logger.info("start TxnService test..."); }

    @Test
    void createTxn() {
        when(txnRepository.save(ArgumentMatchers.any(Txn.class)))
                .thenReturn(transaction);
        when(accountRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(account));
        TxnDto txnDto = new TxnDto();
        txnDto.setTxnId(1L);
        txnDto.setAmount(1);
        txnDto.setDesc("test txn");
        txnDto.setDate(1);
        txnDto.setAccountId(2L);
        TxnDto response = txnService.createTxn(txnDto);

        // assertions
        assertNotNull(response);
        assertEquals(txnDto.getTxnId(), response.getTxnId());
        assertEquals(txnDto.getAmount(), response.getAmount());
        assertEquals(txnDto.getDate(), response.getDate());
        assertEquals(txnDto.getDesc(), response.getDesc());
        assertEquals(txnDto.getAccountId(), response.getAccountId());
    }
}
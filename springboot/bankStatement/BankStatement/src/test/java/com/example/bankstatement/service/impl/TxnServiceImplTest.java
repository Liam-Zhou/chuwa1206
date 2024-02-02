package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.dao.TxnRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.payload.TxnResponsePageable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Alex D.
 */
@ExtendWith(MockitoExtension.class)
class TxnServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(TxnServiceImplTest.class);

    @Mock
    private TxnRepo txnRepo;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private AccountRepo accountRepo;

    @InjectMocks
    private TxnServiceImpl txnService;

    private TxnDto txnDto;
    private Txn txn;
    private Account account;
    private UserProfile userProfile;
    private TxnResponsePageable txnResponsePageable;

    @BeforeEach
    void setUp(){
        logger.info("set up account for each test");
        this.userProfile = new UserProfile(1L,"abc","efg","757123456","abc@gmail.com", LocalDateTime.now(),LocalDateTime.now());
        this.account = new Account(1L,1L,1L,1L,null, this.userProfile,LocalDateTime.now(),LocalDateTime.now());
        this.txn = new Txn(1L,LocalDateTime.now(),LocalDateTime.now(),"abc",1L,account);
        this.txnDto = modelMapper.map(this.txn, TxnDto.class);
        List<TxnDto> txnDtoList = Arrays.asList(txnDto);
        this.txnResponsePageable = new TxnResponsePageable(txnDtoList,1,1,1L,1,true);
        logger.info("successful setup");
    }

    @Test
    void testCreateTxn() {
        long accountNumber = 1L;
        when(accountRepo.findById(accountNumber)).thenReturn(Optional.of(account));
        when(txnRepo.save(any(Txn.class))).thenReturn(txn);

        TxnDto result = txnService.createTxn(accountNumber, txnDto);

        assertNotNull(result);
        assertEquals(txnDto.getAmount(), result.getAmount());
        verify(accountRepo).findById(accountNumber);
        verify(txnRepo).save(any(Txn.class));
    }

    @Test
    void testGetTxnsByAccountIdAndDateRange() {
        long accountId = 1L;
        LocalDateTime startDate = LocalDateTime.now().minusDays(10);
        LocalDateTime endDate = LocalDateTime.now();
        List<Txn> txnList = Collections.singletonList(txn);
        when(txnRepo.findAllByAccount_AccountIDAndCreateDateTimeBetweenOrderByCreateDateTimeDesc(accountId, startDate, endDate))
                .thenReturn(txnList);

        List<TxnDto> results = txnService.getTxnsByAccountIdAndDateRange(accountId, startDate, endDate);

        assertFalse(results.isEmpty());
        assertEquals(txnList.size(), results.size());
        verify(txnRepo).findAllByAccount_AccountIDAndCreateDateTimeBetweenOrderByCreateDateTimeDesc(accountId, startDate, endDate);
    }

    @Test
    void testGetAllPost() {
        int pageNo = 0, pageSize = 10;
        String sortBy = "id", sortDir = "ASC";
        Page<Txn> pageTxns = new PageImpl<>(Collections.singletonList(txn));
        when(txnRepo.findAll(any(PageRequest.class))).thenReturn(pageTxns);

        TxnResponsePageable response = txnService.getAllPost(pageNo, pageSize, sortBy, sortDir);

        assertNotNull(response);
        assertFalse(response.getContent().isEmpty());
        verify(txnRepo).findAll(any(PageRequest.class));
    }

    @Test
    void testGetTxnByTxnId() {
        long txnId = 1L;
        when(txnRepo.findById(txnId)).thenReturn(Optional.of(txn));

        TxnDto result = txnService.getTxnByTxnId(txnId);

        assertNotNull(result);
        verify(txnRepo).findById(txnId);
    }

    @Test
    void testUpdateTxnByTxnId() {
        long txnId = 1L;
        when(txnRepo.findById(txnId)).thenReturn(Optional.of(txn));
        when(txnRepo.save(any(Txn.class))).thenReturn(txn);

        TxnDto updatedTxnDto = txnService.updateTxnByTxnId(txnId, txnDto);

        assertNotNull(updatedTxnDto);
        verify(txnRepo).findById(txnId);
        verify(txnRepo).save(any(Txn.class));
    }

    @Test
    void testDeleteTxnByTxnId() {
        long txnId = 1L;
        when(txnRepo.findById(txnId)).thenReturn(Optional.of(txn));

        txnService.deleteTxnByTxnId(txnId);

        verify(txnRepo).findById(txnId);
        verify(txnRepo).delete(txn);
    }
}
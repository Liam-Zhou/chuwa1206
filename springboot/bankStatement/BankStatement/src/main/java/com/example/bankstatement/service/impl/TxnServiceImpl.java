package com.example.bankstatement.service.impl;

import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.dao.TxnRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.entity.Txn;
import com.example.bankstatement.entity.UserProfile;
import com.example.bankstatement.exception.ResourceNotFoundException;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.service.TxnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alex D.
 */
@Service
public class TxnServiceImpl implements TxnService {
    @Autowired
    private TxnRepo txnRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepo accountRepo;
    @Override
    @Transactional
    public TxnDto createTxn(Long accountNumber, TxnDto txnDto) {
        Txn txn = modelMapper.map(txnDto, Txn.class);
        Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFoundException("Post", "id", accountNumber));
        txn.setAccount(account);
        Txn savedTxn = txnRepo.save(txn);
        TxnDto responseTxnDto = modelMapper.map(savedTxn,TxnDto.class);
        responseTxnDto.setCreateDateTime(savedTxn.getCreateDateTime());

        return responseTxnDto;
    }

    @Override
    public List<TxnDto> getTxnsByAccountIdAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Txn> txns = txnRepo.findAllByAccount_AccountIDAndCreateDateTimeBetweenOrderByCreateDateTimeDesc(
                accountId, startDate, endDate
        );
        return txns.stream().map(txn -> modelMapper.map(txn,TxnDto.class)).collect(Collectors.toList());
    }




}

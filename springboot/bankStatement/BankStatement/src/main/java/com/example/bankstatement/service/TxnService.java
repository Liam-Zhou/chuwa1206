package com.example.bankstatement.service;

import com.example.bankstatement.payload.TxnDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author Alex D.
 */
public interface TxnService {
    TxnDto createTxn(Long accountId, TxnDto txnDto);
    List<TxnDto> getTxnsByAccountIdAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate);

}

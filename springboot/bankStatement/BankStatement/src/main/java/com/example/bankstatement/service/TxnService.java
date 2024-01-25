package com.example.bankstatement.service;

import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.payload.TxnResponsePageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author Alex D.
 */
public interface TxnService {
    TxnDto createTxn(Long accountId, TxnDto txnDto);
    List<TxnDto> getTxnsByAccountIdAndDateRange(Long accountId, LocalDateTime startDate, LocalDateTime endDate);

    TxnResponsePageable getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    TxnDto getTxnByTxnId(Long txnId);

    TxnDto updateTxnByTxnId(Long txnId, TxnDto txnDto);

    void deleteTxnByTxnId(Long txnId);
}

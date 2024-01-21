package org.chuwa.bankstatement.service;

import org.chuwa.bankstatement.payload.TxnDto;

public interface TxnService {
    TxnDto createTxn(TxnDto txnDto);
}

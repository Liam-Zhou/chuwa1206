package org.chuwa.bankstatement.service.impl;

import org.chuwa.bankstatement.dao.AccountRepository;
import org.chuwa.bankstatement.dao.TxnRepository;
import org.chuwa.bankstatement.entities.Txn;
import org.chuwa.bankstatement.payload.TxnDto;
import org.chuwa.bankstatement.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TxnServiceImpl implements TxnService {
    @Autowired
    private TxnRepository txnRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public TxnDto createTxn(TxnDto txnDto) {
        Txn toBeSaved = convertFromDtoToEntity(txnDto);
        Txn saved = this.txnRepository.save(toBeSaved);
        return convertFromEntityToDto(saved);
    }

    private TxnDto convertFromEntityToDto(Txn saved) {
        TxnDto txnDto = new TxnDto();
        txnDto.setTxnId(saved.getTxnId());
        txnDto.setAccountId(saved.getAccount().getAccId());
        txnDto.setAmount(saved.getAmount());
        txnDto.setDesc(saved.getDesc());
        txnDto.setDate(saved.getDate());
        return txnDto;
    }

    private Txn convertFromDtoToEntity(TxnDto txnDto) {
        Txn txn = new Txn();
//        txn.setTxnId(txnDto.getTxnId());
        txn.setAccount(accountRepository.findById(txnDto.getAccountId()).orElse(null));
        txn.setAmount(txnDto.getAmount());
        txn.setDesc(txnDto.getDesc());
        txn.setDate(txnDto.getDate());
        return txn;
    }
}

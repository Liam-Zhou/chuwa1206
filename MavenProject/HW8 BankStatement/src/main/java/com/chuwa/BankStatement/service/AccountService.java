package com.chuwa.BankStatement.service;

import com.chuwa.BankStatement.dao.AccountRepository;
import com.chuwa.BankStatement.dao.TxnRepository;
import com.chuwa.BankStatement.dao.UserRepository;
import com.chuwa.BankStatement.entity.Account;
import com.chuwa.BankStatement.entity.Txn;
import com.chuwa.BankStatement.entity.User;
import com.chuwa.BankStatement.payload.BankStatement;
import com.chuwa.BankStatement.payload.TxnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TxnRepository txnRepository;

    public BankStatement getAccountDetails(long userId, int month) {
        User user = null;
        try {
            user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        Account account = user.getAccount();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();

        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date endDate = cal.getTime();

        List<TxnDto> txns = txnRepository.findAllByAccountAndDateBetween(account, startDate, endDate).stream().map(this::convertTxntoDTO).collect(Collectors.toList());

        return new BankStatement(user.getName(), user.getAddr(), account.getAccountNumber(), txns);
    }

    private TxnDto convertTxntoDTO(Txn txn){
        //        txnDto.setAmount(txn.getAmount());
//        txnDto.setDate(txn.getDate());
//        txnDto.setDescription(txn.getDescription());
        return new TxnDto(txn);
    }
}

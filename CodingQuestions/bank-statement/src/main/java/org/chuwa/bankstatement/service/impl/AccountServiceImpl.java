package org.chuwa.bankstatement.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

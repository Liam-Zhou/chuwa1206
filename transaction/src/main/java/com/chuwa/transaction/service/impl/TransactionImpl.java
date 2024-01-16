package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.dao.TransactionRepository;
import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransactionImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction toBeSaved = convertDtoToEntity(transactionDto);
        Transaction save = this.transactionRepository.save(toBeSaved);
        return convertEntityToDto(save);
    }

    private TransactionDto convertEntityToDto(Transaction save) {
        TransactionDto response = new TransactionDto();
        response.setTransactionId(save.getId());
        response.setAmount(save.getAmount());
        response.setDescription(save.getDescription());
        response.setCreateDateTime(save.getCreateDateTime());
        return response;
    }

    private Transaction convertDtoToEntity(TransactionDto transactionDto) {
        Transaction toBeSaved = new Transaction();
        toBeSaved.setAmount(transactionDto.getAmount());
        toBeSaved.setAccountId(transactionDto.getAccountId());
        toBeSaved.setDescription(transactionDto.getDescription());
        return toBeSaved;
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto, long id) {
        return null;
    }

    @Override
    public TransactionDto deleteTransaction(long id) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransactionByAccountIdAndTimeRange(long accountId, LocalDateTime a, LocalDateTime b) {
        List<Transaction> transactions = this.transactionRepository.findByAccountIdAndCreateDateTimeBetween(accountId, a, b);
        List<TransactionDto> response = transactions.stream().map(transaction -> convertEntityToDto(transaction))
                .collect(Collectors.toList());
        return response;
    }
}

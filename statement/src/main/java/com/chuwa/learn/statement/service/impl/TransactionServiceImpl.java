package com.chuwa.learn.statement.service.impl;

import com.chuwa.learn.statement.dao.TransactionRepository;
import com.chuwa.learn.statement.entity.Transaction;
import com.chuwa.learn.statement.payload.TransactionDto;
import com.chuwa.learn.statement.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = dtoToEntity(transactionDto);
        transactionRepository.save(transaction);
        return entityToDto(transaction);
    }

    @Override
    public List<TransactionDto> getTransactions(long id, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByAccountIdAndDateBetween(id,startDate,endDate)
                .stream().map(this::entityToDto).collect(Collectors.toList());
    }




    private TransactionDto entityToDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        transactionDto.setDate(transaction.getDate().format(formatter));
        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDescription(transaction.getDescription());
        return  transactionDto;
    }

    private Transaction dtoToEntity(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setDescription(transactionDto.getDescription());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        transaction.setDate(LocalDateTime.parse(transactionDto.getDate(),formatter));
        return transaction;
    }
}

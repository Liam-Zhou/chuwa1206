package com.example.bankstatement.batch;


import com.example.bankstatement.config.CronConfig;
import com.example.bankstatement.dao.TxnRepo;
import com.example.bankstatement.dao.AccountRepo;
import com.example.bankstatement.entity.Account;
import com.example.bankstatement.payload.AccountDto;
import com.example.bankstatement.payload.AccountDtoWithoutUserProfile;
import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.service.AccountService;
import com.example.bankstatement.service.ReportService;
import com.example.bankstatement.service.TxnService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Alex D.
 */
@Slf4j
@Component
public class ReportHandler {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ReportService reportService;

    @Autowired
    AccountService accountService;

//    @Scheduled(cron = "1 0 0 * * MON")

    public void getTxnsReports(){
        log.info("Scheduling Txns Report, delay 3 s");
        CronConfig.getScheduledExecutor().schedule(() -> {
                    try {
                        reportGenerator();
                    } catch (DocumentException e) {
                        throw new RuntimeException(e);
                    }
                },
                3,
                TimeUnit.SECONDS);
    }

    @Scheduled(cron = "3 0 0 * * *")
    public void reportGenerator() throws DocumentException {
        log.info("generating Txns report");
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts) {
            AccountDto accountDto = accountService.getAccountByUserIdByAccountId(1L, account.getId());
            List<TxnDto> txnDtoList = accountDto.getTxns().stream()
                    .sorted(Comparator.comparing(TxnDto::getCreateDateTime).reversed())
                    .collect(Collectors.toList());
            reportService.generatePdfReport(txnDtoList);
        }
        log.info("finished generating Txn report");
    }

//    public void getLast24HoursReport() {
//        log.info("Scheduling Last24HoursReport report, delay 3 s");
//        CronConfig.getScheduledExecutor().schedule(() -> {
//                    try {
//                        reportGenerator();
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                },
//                3,
//                TimeUnit.SECONDS);
//    }
//
//    private void reportGenerator() throws JsonProcessingException {
//        log.info("report generating ...");
//        LocalDateTime now = LocalDateTime.now();
//        log.info(now.toString());
//        LocalDateTime previousDay = now.minusDays(300);
//        log.info(previousDay.toString());
//        List<Post> postIds = postRepository.getAllPostIdsByCreateDateBetweenStartTimeAndEndTime(previousDay, now);
//        log.info("total new posts: " + postIds.size());
//        HashMap<Long, Long> hm = new HashMap<>(16);
//        postIds.forEach((post) -> {
//            log.info("generate post: " + post);
//            Long count = commentRepository.countCommentsByPostIs(post);
//            hm.put(post.getId(), count);
//        });
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(hm);
//        log.info(s);
//    }

}

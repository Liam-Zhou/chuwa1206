package com.chuwa.transaction.integration;

import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.payload.UserProfileDto;
import com.chuwa.transaction.service.BankstatementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BankStatementServiceIntegrationTest {
    @Autowired
    private BankstatementService bankstatementService;


    @Test
    void createBankstatementIntegrationTest() {
        // Mock data
        long userId = 1;
        String month = "2";
        UserProfileDto mockUserProfile = new UserProfileDto();
        mockUserProfile.setName("ModdleMapper name");
        mockUserProfile.setAddress("address");
        int monthNumber = Integer.parseInt(month);


        LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0);

        LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0)
                .with(TemporalAdjusters.lastDayOfMonth())
                .withHour(23)
                .withMinute(59)
                .withSecond(59);

        System.out.println("userId = " + userId);
        BankStatementDto actualBankStatement = bankstatementService.createBankstatement(userId, month);

        // Assert the result
        assertEquals(mockUserProfile.getName(), actualBankStatement.getUsername());
        assertEquals(mockUserProfile.getAddress(), actualBankStatement.getAddress());
        // Add more assertions based on your specific requirements
    }
}

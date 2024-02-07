package com.chuwa.transaction.service.impl;

import com.chuwa.transaction.entity.Transaction;
import com.chuwa.transaction.payload.BankStatementDto;
import com.chuwa.transaction.payload.TransactionDto;
import com.chuwa.transaction.vo.BankStatementVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PdfServiceImplTest {
    @InjectMocks
    private PdfServiceImpl pdfService;

    @Mock
    private BankStatementDto bankStatementDtoMock;

    @Mock
    private BankStatementVo bankStatementVoMock;

    private TransactionDto transactionDto;
    private Transaction transaction;

    @Test
    void testGeneratePdf() {
        int monthNumber = Integer.parseInt("1");
//        // Arrange
//        LocalDateTime firstDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0);
//
//        // Get the last day of the month
//        LocalDateTime lastDayOfMonth = LocalDateTime.of(LocalDate.now().getYear(), Month.of(monthNumber), 1, 0, 0)
//                .with(TemporalAdjusters.lastDayOfMonth())
//                .withHour(23)
//                .withMinute(59)
//                .withSecond(59);
        BigDecimal userBigDecimal = new BigDecimal(100.0);
        LocalDateTime localDateTime = LocalDateTime.now();
        BankStatementDto bankStatementDto = new BankStatementDto(/* your constructor parameters */);
        BankStatementVo bankStatementVo = new BankStatementVo(/* your constructor parameters */);
        this.transaction = new Transaction(1L,1L, localDateTime, "deposit", userBigDecimal);
        this.transactionDto = new TransactionDto(1L,1L, "deposit", userBigDecimal, localDateTime);
        // Mock data for testing
        HashMap<String, List<TransactionDto>> testData = new HashMap<>();
        testData.put("key1", new ArrayList<>(List.of(transactionDto)));
        testData.put("key2", new ArrayList<>());
        bankStatementDto.setData(testData);

        try {
            // Act
            byte[] result = pdfService.generatePdf(bankStatementDto, bankStatementVo);

            // Assert
            assertNotNull(result);

            // Add more specific assertions based on your expected behavior
            // For example, you could use a PDF library to inspect the generated PDF content.

        } catch (Exception e) {
            // Handle exceptions if needed
            e.printStackTrace();
        }
    }
}

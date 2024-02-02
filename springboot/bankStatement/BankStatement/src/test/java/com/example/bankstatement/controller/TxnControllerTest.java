package com.example.bankstatement.controller;

import com.example.bankstatement.payload.TxnDto;
import com.example.bankstatement.payload.TxnResponsePageable;
import com.example.bankstatement.service.ReportService;
import com.example.bankstatement.service.TxnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TxnController.class)
class TxnControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TxnService txnService;

    @MockBean
    private ReportService reportService;

    @Autowired
    private ObjectMapper objectMapper;

    private TxnDto txnDto;

    @BeforeEach
    void setUp() {
        // Initialize your test data here
        txnDto = new TxnDto(/* parameters */);
    }

    @Test
    void createTxnTest() throws Exception {
        given(txnService.createTxn(anyLong(), any(TxnDto.class))).willReturn(txnDto);

        mockMvc.perform(post("/api/v1/users/{userId}/accounts/{accountId}/txns", 1L, 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(txnDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(txnDto)));

        verify(txnService).createTxn(anyLong(), any(TxnDto.class));
    }

    @Test
    void getTxnsByAccountIdAndDateRangeTest() throws Exception {
        List<TxnDto> txnDtos = Arrays.asList(txnDto);
        given(txnService.getTxnsByAccountIdAndDateRange(anyLong(), any(LocalDateTime.class), any(LocalDateTime.class)))
                .willReturn(txnDtos);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts/{accountId}/txns", 1L, 1L)
                        .param("startDate", "2020-01-01T00:00:00")
                        .param("endDate", "2020-01-02T00:00:00"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(txnDtos)));

        verify(txnService).getTxnsByAccountIdAndDateRange(anyLong(), any(LocalDateTime.class), any(LocalDateTime.class));
    }

    @Test
    void getAllTxnByAccountIdTest() throws Exception {
        TxnResponsePageable response = new TxnResponsePageable(); // Initialize with test data
        given(txnService.getAllPost(anyInt(), anyInt(), anyString(), anyString())).willReturn(response);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts/{accountId}/txns-pageable", 1L, 1L)
                        .param("pageNo", "0")
                        .param("pageSize", "10")
                        .param("sortBy", "date")
                        .param("sortDir", "asc"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));

        verify(txnService).getAllPost(anyInt(), anyInt(), anyString(), anyString());
    }

    @Test
    void getTxnByTxnIdTest() throws Exception {
        given(txnService.getTxnByTxnId(anyLong())).willReturn(txnDto);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts/{accountId}/txns/{txnId}", 1L, 1L, 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(txnDto)));

        verify(txnService).getTxnByTxnId(anyLong());
    }

    @Test
    void updateTxnByTxnIdTest() throws Exception {
        given(txnService.updateTxnByTxnId(anyLong(), any(TxnDto.class))).willReturn(txnDto);

        mockMvc.perform(put("/api/v1/users/{userId}/accounts/{accountId}/txns/{txnId}", 1L, 1L, 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(txnDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(txnDto)));

        verify(txnService).updateTxnByTxnId(anyLong(), any(TxnDto.class));
    }

    @Test
    void getTransactionsReportTest() throws Exception {
        byte[] pdfContent = new byte[100]; // Mock PDF content
        given(reportService.generatePdfReport(anyList())).willReturn(pdfContent);

        mockMvc.perform(get("/api/v1/users/{userId}/accounts/{accountId}/txns/report", 1L, 1L)
                        .param("startDate", "2020-01-01T00:00:00")
                        .param("endDate", "2020-01-02T00:00:00"))
                .andExpect(status().isOk())
                .andExpect(header().exists(HttpHeaders.CONTENT_DISPOSITION));

        verify(reportService).generatePdfReport(anyList());
    }

    @Test
    void deleteTxnByTxnIdTest() throws Exception {
        doNothing().when(txnService).deleteTxnByTxnId(anyLong());

        mockMvc.perform(delete("/api/v1/users/{userId}/accounts/{accountId}/txns/{txnId}", 1L, 1L, 1L))
                .andExpect(status().isOk())
                .andExpect(content().string("The txn deleted successfully."));

        verify(txnService).deleteTxnByTxnId(anyLong());
    }


}
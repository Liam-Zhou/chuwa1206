package com.chuwa.statement.service.inter;

import com.chuwa.statement.payload.StatementDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatementService {
    List<StatementDto> findStatementByUserIdAndDateBetween(long userId, LocalDateTime startDate, LocalDateTime endDate);
}

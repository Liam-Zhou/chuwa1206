package com.chuwa.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author xiaorui
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankStatementRequestDto {
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

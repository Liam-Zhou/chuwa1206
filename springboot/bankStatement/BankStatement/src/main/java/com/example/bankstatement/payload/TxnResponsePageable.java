package com.example.bankstatement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * @author Alex D.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TxnResponsePageable {
    private List<TxnDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

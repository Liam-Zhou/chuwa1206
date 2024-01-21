package org.chuwa.bankstatement.controller;

import org.chuwa.bankstatement.payload.TxnDto;
import org.chuwa.bankstatement.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/txn")
public class TxnController {
    @Autowired
    private TxnService txnService;

    @PostMapping
    public ResponseEntity<TxnDto> postTxn(@RequestBody TxnDto txnDto) {
        TxnDto txn = txnService.createTxn(txnDto);
        return new ResponseEntity<>(txn, HttpStatus.OK);
    }
}

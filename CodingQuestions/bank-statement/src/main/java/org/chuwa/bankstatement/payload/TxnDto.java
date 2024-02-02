package org.chuwa.bankstatement.payload;

import java.time.LocalDateTime;

public class TxnDto {

    private Long txnId;
    private Long accountId;
    private Integer date;
    private String desc;
    private Integer amount;

    public TxnDto(Long txnId, Long accountId, Integer date, String desc, Integer amount) {
        this.txnId = txnId;
        this.accountId = accountId;
        this.date = date;
        this.desc = desc;
        this.amount = amount;
    }

    public TxnDto() {
    }

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TxnDto{" +
                "txnId=" + txnId +
                ", accountId=" + accountId +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                ", amount=" + amount +
                '}';
    }
}

package com.bca.payment.gatway.odp;

import java.sql.Date;

public class TransactionRequest {
    private String cardNumber;
    private Integer cvv;
    private String expDate;
    private Double amount;
    private Integer merchantId;
    private Integer refTransaction;

    private Date dateTransaction;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getRefTransaction() {
        return refTransaction;
    }

    public void setRefTransaction(Integer refTransaction) {
        this.refTransaction = refTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}

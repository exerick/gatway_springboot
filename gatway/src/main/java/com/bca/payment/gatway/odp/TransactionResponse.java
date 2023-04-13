package com.bca.payment.gatway.odp;

public class TransactionResponse {
    private Integer refTransaction;
    private String status;
    private String cardNumber;
    private String expDate;
    private Integer merchantId;

    private Integer approvalCode;
    private Double amount;

    private Integer transactionId;


    public Integer getRefTransaction() {
        return refTransaction;
    }

    public void setRefTransaction(Integer refTransaction) {
        this.refTransaction = refTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(Integer approvalCode) {
        this.approvalCode = approvalCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}

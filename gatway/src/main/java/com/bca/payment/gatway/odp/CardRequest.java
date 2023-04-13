package com.bca.payment.gatway.odp;

public class CardRequest {
    private String cardNumber;
    private String embossCard;
    private String expDate;
    private Integer cvv;
    private Double limitCard;
    private String principle;
    private String status;

    private Integer customerNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEmbossCard() {
        return embossCard;
    }

    public void setEmbossCard(String embossCard) {
        this.embossCard = embossCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Double getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(Double limitCard) {
        this.limitCard = limitCard;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}

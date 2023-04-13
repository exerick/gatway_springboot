package com.bca.payment.gatway.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class CardModel {

    @Id
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name ="emboss_card")
    private String embossCard;
    @Column(name ="exp_date")
    private String expDate;
    @Column(name ="cvv")
    private Integer cvv;
    @Column(name = "limit_card")
    private Double limitCard;
    @Column(name = "avail_limit_lard")
    private Double availLimitCard;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "principle")
    private String principle;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    @JsonManagedReference
    private CustomerModel customerModel;

    @JsonBackReference
    @OneToMany(mappedBy = "transactionId" )
    private List<TransactionModel> transactionModels;

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

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public List<TransactionModel> getTransactionModels() {
        return transactionModels;
    }

    public void setTransactionModels(List<TransactionModel> transactionModels) {
        this.transactionModels = transactionModels;
    }

    public Double getAvailLimitCard() {
        return availLimitCard;
    }

    public void setAvailLimitCard(Double availLimitCard) {
        this.availLimitCard = availLimitCard;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

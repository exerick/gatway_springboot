package com.bca.payment.gatway.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    @Column(name = "date")
    private Date date;

    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "description")
    private String description;

    @Column(name = "nominal_transaction")
    private Double nominalTransaction;
    @Column(name = "debet_credit")
    private Boolean debetCredit;
    @Column(name = "status")
    private String status;

    @Column(name = "approval_code")
    private Integer approvalCode;

    @ManyToOne
    @JoinColumn(name = "card_number")
    @JsonManagedReference
    private CardModel cardModel;

    @ManyToOne
    @JoinColumn(name = "merchant_number")
    @JsonManagedReference
    private MerchantModel merchantModel;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getNominalTransaction() {
        return nominalTransaction;
    }

    public void setNominalTransaction(Double nominalTransaction) {
        this.nominalTransaction = nominalTransaction;
    }

    public Boolean getDebetCredit() {
        return debetCredit;
    }

    public void setDebetCredit(Boolean debetCredit) {
        this.debetCredit = debetCredit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(Integer approvalCode) {
        this.approvalCode = approvalCode;
    }

    public CardModel getCardModel() {
        return cardModel;
    }

    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    public MerchantModel getMerchantModel() {
        return merchantModel;
    }

    public void setMerchantModel(MerchantModel merchantModel) {
        this.merchantModel = merchantModel;
    }
}

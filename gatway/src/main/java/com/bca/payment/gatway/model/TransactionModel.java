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

}

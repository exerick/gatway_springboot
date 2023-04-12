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


}

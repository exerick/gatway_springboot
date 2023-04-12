package com.bca.payment.gatway.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "merchant")
public class MerchantModel {

    @Id
    @Column(name = "merchant_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer merchantNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "rekening_merchant")
    private Integer rekeningMerchant;
    @Column(name = "status")
    private String status;
    @Column(name = "email")
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy = "merchantNumber" )
    private List<MerchantModel> merchantModels;



}


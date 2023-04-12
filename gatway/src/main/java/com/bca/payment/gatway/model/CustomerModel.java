package com.bca.payment.gatway.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerModel {
    @Id
    @Column(name = "customer_number")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer customerNumber;
    @Column(name = "name")
    private String name;
    @Column(name ="phone_number")
    private String phoneNumber;
    @Column(name ="email")
    private String email;
    @Column(name ="address")
    private String address;
    @Column(name ="status")
    private String status;
    @Column(name ="birthDate")
    private Date birthDate;

    @JsonBackReference
    @OneToMany(mappedBy = "cardNumber" )
    private List<CardModel> cardModels;

}

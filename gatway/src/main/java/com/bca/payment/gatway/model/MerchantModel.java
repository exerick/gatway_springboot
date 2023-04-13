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

    public Integer getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(Integer merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRekeningMerchant() {
        return rekeningMerchant;
    }

    public void setRekeningMerchant(Integer rekeningMerchant) {
        this.rekeningMerchant = rekeningMerchant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MerchantModel> getMerchantModels() {
        return merchantModels;
    }

    public void setMerchantModels(List<MerchantModel> merchantModels) {
        this.merchantModels = merchantModels;
    }
}


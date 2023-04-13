package com.bca.payment.gatway.odp;

public class MerchantRequest {
    private Integer merchantNumber;
    private String name;
    private String phoneNumber;
    private String address;
    private Integer rekeningMerchant;
    private String status;
    private String email;

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
}

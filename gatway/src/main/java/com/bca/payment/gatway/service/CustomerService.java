package com.bca.payment.gatway.service;

import com.bca.payment.gatway.model.CustomerModel;
import com.bca.payment.gatway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerModel> allCustomer(){
        return customerRepository.findAll();
    }


}

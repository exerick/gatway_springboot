package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.CustomerModel;
import com.bca.payment.gatway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/all")
    public @ResponseBody List<CustomerModel> inquiryAllCustomer(){
        return customerRepository.retrieveAll();
    }
}

package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.CustomerModel;
import com.bca.payment.gatway.odp.CustomerRequest;
import com.bca.payment.gatway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CustomerModel> inquiryAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody CustomerModel inquiryCustomerByCustNo(@PathVariable("id") Integer custNo){
        return customerRepository.findCustomerByCustomerNumber(custNo);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public CustomerModel addCust(@RequestBody CustomerRequest cr){
        CustomerModel cm = new CustomerModel();
        cm.setName(cr.getName());
        cm.setPhoneNumber(cr.getPhoneNumber());
        cm.setEmail(cr.getEmail());
        cm.setAddress(cr.getAddress());
        cm.setStatus("normal");
        cm.setBirthDate(cr.getBirthDate());
        return customerRepository.save(cm);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerModel updateCust(@RequestBody CustomerRequest cr,@PathVariable("id") Integer id){
        CustomerModel cm = new CustomerModel();
        cm.setCustomerNumber(id);
        cm.setName(cr.getName());
        cm.setPhoneNumber(cr.getPhoneNumber());
        cm.setEmail(cr.getEmail());
        cm.setAddress(cr.getAddress());
        cm.setStatus("normal");
        cm.setBirthDate(cr.getBirthDate());
        return customerRepository.save(cm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCust(@PathVariable("id") Integer id){
        customerRepository.deleteById(id);
    }




}

package com.bca.payment.gatway.repository;

import com.bca.payment.gatway.model.CustomerModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {

    CustomerModel findCustomerById(Integer customerNumber);


    List<CustomerModel> retrieveAll();
}

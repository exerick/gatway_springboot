package com.bca.payment.gatway.repository;

import com.bca.payment.gatway.model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel,Integer> {
    TransactionModel findTransactionByTransactionId(Integer trxId);
    List<TransactionModel> findAll();
}

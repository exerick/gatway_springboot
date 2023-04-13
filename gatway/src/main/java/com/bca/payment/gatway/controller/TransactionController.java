package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.TransactionModel;
import com.bca.payment.gatway.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<TransactionModel> inquiryAllTrx(){
        return transactionRepository.findAll();
    }
    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody TransactionModel inquiryTrxByTrxId(Integer trxId){
        return transactionRepository.findTransactionByTransactionId(trxId);
    }
}

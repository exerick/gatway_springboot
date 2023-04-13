package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.CardModel;
import com.bca.payment.gatway.model.TransactionModel;
import com.bca.payment.gatway.odp.TransactionRequest;
import com.bca.payment.gatway.odp.TransactionResponse;
import com.bca.payment.gatway.repository.CardRepository;
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

    @Autowired
    CardRepository cardRepository;
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

    //authorization
    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody TransactionResponse authTransaction(@RequestBody TransactionRequest trq){
        //auth seq
        Boolean cardChek = false;
        TransactionResponse trs = new TransactionResponse();
        trs.setRefTransaction(trq.getRefTransaction());
        trs.setCardNumber(trq.getCardNumber());
        trs.setExpDate(trq.getExpDate());
        trs.setMerchantId(trq.getMerchantId());
        trs.setApprovalCode(0);
        trs.setAmount(trq.getAmount());

        //cek level kartu
        String cardAuth = cardCheck(trq.getCardNumber(),trq.getExpDate(), trq.getCvv(), trq.getAmount());
        if(cardAuth.equalsIgnoreCase("Approved"))
        {
            cardChek = true;
        }
        else {

        }

        //validasi merchant


        return trs;
    }

    private String cardCheck(String cardNo, String expDate, Integer cvv, Double amount){
        CardModel cardModel = cardRepository.findCardByCardNumber(cardNo);

        if (!cardModel.getCardNumber().equalsIgnoreCase(cardNo)){
            return "Invalid Card Number";
        } else if (!cardModel.getCvv().equals(cvv)) {
            return "Invalid Card CVV";
        } else if (!cardModel.getExpDate().equalsIgnoreCase(expDate)) {
            return "Invalid Card Exp";
        } else if (cardModel.getAvailLimitCard() < amount) {
            return "insufficient limits";
        } else if (!cardModel.getStatus().equalsIgnoreCase("normal")) {
            return "Card Has Bad Status";
        } else {
            return "Approved";
        }
    }

    private TransactionModel addTransactionHistory(){
        TransactionModel transactionModel = new TransactionModel();


        return transactionModel;
    }

}

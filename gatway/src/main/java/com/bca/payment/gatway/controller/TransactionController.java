package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.CardModel;
import com.bca.payment.gatway.model.MerchantModel;
import com.bca.payment.gatway.model.TransactionModel;
import com.bca.payment.gatway.odp.TransactionRequest;
import com.bca.payment.gatway.odp.TransactionResponse;
import com.bca.payment.gatway.repository.CardRepository;
import com.bca.payment.gatway.repository.MerchantRepository;
import com.bca.payment.gatway.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    MerchantRepository merchantRepository;
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
    @Transactional
    public @ResponseBody TransactionResponse authTransaction(@RequestBody TransactionRequest trq){
        //auth seq
        Boolean cardCheck = false;
        Boolean merCheck = false;
        Boolean limitCheck = false;

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
            cardCheck = true;
        }
        else {
            TransactionModel tm = addTransactionHistory(cardAuth,trq);
            trs.setApprovalCode(tm.getApprovalCode());
            trs.setStatus(tm.getStatus());
            trs.setTransactionId(tm.getTransactionId());
            return trs;
        }

        //validasi merchant
        String merchantAuth = merchantCheck(trq.getMerchantId());
        if(merchantAuth.equalsIgnoreCase("Approved")){
            merCheck = true;
        }
        else {
            TransactionModel tm = addTransactionHistory(cardAuth,trq);
            trs.setApprovalCode(tm.getApprovalCode());
            trs.setStatus(tm.getStatus());
            trs.setTransactionId(tm.getTransactionId());
            return trs;
        }

        //proses potong limit nasabah
        String limitAuth = updateLimitCard(trq.getCardNumber(), trq.getAmount());
        if (limitAuth.equalsIgnoreCase("Approved")){
            limitCheck = true;
        }else {
            TransactionModel tm = addTransactionHistory(limitAuth,trq);
            trs.setApprovalCode(tm.getApprovalCode());
            trs.setStatus(tm.getStatus());
            trs.setTransactionId(tm.getTransactionId());
            return trs;
        }

        if (!(limitCheck && cardCheck && merCheck)){
            TransactionModel tm = addTransactionHistory("Decline",trq);
            trs.setApprovalCode(tm.getApprovalCode());
            trs.setStatus(tm.getStatus());
            trs.setTransactionId(tm.getTransactionId());
            return trs;
        }
        TransactionModel tm = addTransactionHistory("Approved",trq);
        trs.setApprovalCode(tm.getApprovalCode());
        trs.setStatus(tm.getStatus());
        trs.setTransactionId(tm.getTransactionId());
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

    private String merchantCheck(Integer merchantNumber){
        MerchantModel merchantModel = merchantRepository.findMerchantByMerchantNumber(merchantNumber);
        if (!merchantModel.getMerchantNumber().equals(merchantNumber)){
            return "Invalid Merchant Number";
        } else if (!merchantModel.getStatus().equals("normal")) {
            return "Merchant Not Normal";
        }
        else {
            return "Approved";
        }

    }

    private TransactionModel addTransactionHistory(String status, TransactionRequest transactionRequest){
        //prepare input
        Date trxDate = new Date();
        Timestamp trxTime = new Timestamp(System.currentTimeMillis());

        Integer min = 100;
        Integer max = 999999;
        Integer random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setDate(trxDate);
        transactionModel.setTimestamp(trxTime);

        transactionModel.setStatus(status);
        transactionModel.setNominalTransaction(transactionRequest.getAmount());
        transactionModel.setDebetCredit(true);
        if (status.equalsIgnoreCase("Approved"))
        {
            transactionModel.setApprovalCode(random_int);
        }
        else {
            transactionModel.setApprovalCode(0);
        }


        CardModel cardModel = cardRepository.findCardByCardNumber(transactionRequest.getCardNumber());
        transactionModel.setCardModel(cardModel);

        MerchantModel merchantModel = merchantRepository.findMerchantByMerchantNumber(transactionRequest.getMerchantId());
        transactionModel.setMerchantModel(merchantModel);
        transactionModel.setDescription(merchantModel.getName());

        return transactionRepository.save(transactionModel);
    }

    private String updateLimitCard(String cardNo, Double amount){
        CardModel cardModel = cardRepository.findCardByCardNumber(cardNo);
        if(!cardModel.getCardNumber().equalsIgnoreCase(cardNo)){
            return "Invalid Card Number";
        }
        else {
            Double newBalance = cardModel.getBalance() + amount;
            Double newAvailLimit = cardModel.getAvailLimitCard() - amount;
            cardModel.setAvailLimitCard(newAvailLimit);
            cardModel.setBalance(newBalance);
            cardRepository.save(cardModel);
            return "Approved";
        }
    }

}

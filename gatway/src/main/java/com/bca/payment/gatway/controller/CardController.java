package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.CardModel;
import com.bca.payment.gatway.model.CustomerModel;
import com.bca.payment.gatway.odp.CardRequest;
import com.bca.payment.gatway.repository.CardRepository;
import com.bca.payment.gatway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody CardModel inquiryCardByCardNo(@RequestParam("cardno") String cardNo){
        return cardRepository.findCardByCardNumber(cardNo);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CardModel> inquiryCard (){
        return cardRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public CardModel addCard(@RequestBody CardRequest cardRequest){

        CardModel cm = new CardModel();
        cm.setCardNumber(cardRequest.getCardNumber());
        cm.setEmbossCard(cardRequest.getEmbossCard());
        cm.setExpDate(cardRequest.getExpDate());
        cm.setCvv(cardRequest.getCvv());
        cm.setLimitCard(cardRequest.getLimitCard());
        cm.setPrinciple(cardRequest.getPrinciple());
        cm.setStatus("normal");
        cm.setBalance(Double.valueOf(0));
        cm.setAvailLimitCard(cardRequest.getLimitCard());
        CustomerModel customerModel = customerRepository.findCustomerByCustomerNumber(cardRequest.getCustomerNumber());
        cm.setCustomerModel(customerModel);
        return cardRepository.save(cm);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public CardModel updateCard(@RequestBody CardRequest cardRequest){
        CardModel cm = cardRepository.findCardByCardNumber(cardRequest.getCardNumber());
        cm.setEmbossCard(cardRequest.getEmbossCard());
        cm.setExpDate(cardRequest.getExpDate());
        cm.setCvv(cardRequest.getCvv());
        cm.setLimitCard(cardRequest.getLimitCard());
        Double availLimitNew = cardRequest.getLimitCard() - cm.getBalance();
        cm.setAvailLimitCard(availLimitNew);
        cm.setPrinciple(cardRequest.getPrinciple());
        cm.setStatus(cardRequest.getStatus());
        CustomerModel customerModel = customerRepository.findCustomerByCustomerNumber(cardRequest.getCustomerNumber());
        cm.setCustomerModel(customerModel);
        return cardRepository.save(cm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletecard(@PathVariable("cardno") String cardno){
        cardRepository.deleteBycardNumber(cardno);
    }
}

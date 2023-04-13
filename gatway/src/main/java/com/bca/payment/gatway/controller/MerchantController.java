package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.MerchantModel;
import com.bca.payment.gatway.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {
    @Autowired
    MerchantRepository merchantRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<MerchantModel> inquiryAllMerchant(){
        return merchantRepository.findAll();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody MerchantModel inquiryMerchantById(@RequestParam("merid") Integer merid){
        return merchantRepository.findMerchantByMerchantNumber(merid);
    }
}

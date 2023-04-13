package com.bca.payment.gatway.controller;

import com.bca.payment.gatway.model.MerchantModel;
import com.bca.payment.gatway.odp.MerchantRequest;
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

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<MerchantModel> inquiryAllMerchant(){
        return merchantRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody MerchantModel inquiryMerchantById(@PathVariable("id") Integer merid){
        return merchantRepository.findMerchantByMerchantNumber(merid);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody MerchantModel addMerchant(@RequestBody MerchantRequest mr){
        MerchantModel mm = new MerchantModel();
        mm.setName(mr.getName());
        mm.setPhoneNumber(mr.getPhoneNumber());
        mm.setAddress(mr.getAddress());
        mm.setRekeningMerchant(mr.getRekeningMerchant());
        mm.setStatus(mr.getStatus());
        mm.setEmail(mr.getEmail());
        return merchantRepository.save(mm);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody MerchantModel updateMerchant(@RequestBody MerchantRequest mr,@PathVariable("id") Integer merid){
        MerchantModel mm = new MerchantModel();
        mm.setMerchantNumber(merid);
        mm.setName(mr.getName());
        mm.setPhoneNumber(mr.getPhoneNumber());
        mm.setAddress(mr.getAddress());
        mm.setRekeningMerchant(mr.getRekeningMerchant());
        mm.setStatus(mr.getStatus());
        mm.setEmail(mr.getEmail());
        return merchantRepository.save(mm);
    }
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMerchant(@PathVariable("id") Integer merid){
        merchantRepository.deleteById(merid);
    }

}

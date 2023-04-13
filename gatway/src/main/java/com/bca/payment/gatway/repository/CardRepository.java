package com.bca.payment.gatway.repository;

import com.bca.payment.gatway.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardModel,Integer> {
    CardModel findCardByCardNumber(String cardNo);
    List<CardModel> findAll();

    void deleteBycardNumber(String cardno);
}

package com.bca.payment.gatway.repository;

import com.bca.payment.gatway.model.MerchantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantRepository extends JpaRepository<MerchantModel, Integer> {
    MerchantModel findMerchantByMerchantNumber(Integer merId);

    List<MerchantModel> findAll();
}

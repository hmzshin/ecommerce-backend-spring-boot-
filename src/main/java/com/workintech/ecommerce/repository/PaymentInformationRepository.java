package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.PaymentInformation;

public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Long> {

}

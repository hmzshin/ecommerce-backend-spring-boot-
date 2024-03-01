package com.workintech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.ecommerce.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}

package com.workintech.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workintech.ecommerce.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c WHERE c.user.id=:id")
    List<Card> findAllByUserId(@Param("id") Long id);

    @Query("SELECT c FROM Card c WHERE c.cardNo=:cardNo")
    Optional<Card> findByCardNo(@Param("cardNo") String cardNo);


}

package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.dto.CardDto;

public interface CardService {

    List<CardDto> findAllByUserId(Long userId);

    CardDto save(CardDto card);

}

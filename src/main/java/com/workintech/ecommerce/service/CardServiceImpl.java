package com.workintech.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.ecommerce.dto.CardDto;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.repository.CardRepository;
import com.workintech.ecommerce.util.CardFactory;
import com.workintech.ecommerce.util.EntityValidations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;
    private UserService userService;
    private CardFactory cardFactory;

    @Override
    public List<CardDto> findAllByUserId(Long userId) {
        userService.findById(userId);
        List<Card> cards = cardRepository.findAllByUserId(userId);
        return cardFactory.createCardDto(cards);
    }

    @SuppressWarnings("null")
    @Override
    public CardDto save(CardDto cardDto) {
        EntityValidations.isCardCredentialsValid(cardDto);
        Card c = cardFactory.createCard(cardDto);
        Card saved = cardRepository.save(c);
        return cardFactory.createCardDto(saved);
    }

}

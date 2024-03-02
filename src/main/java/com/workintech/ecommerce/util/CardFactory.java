package com.workintech.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.CardDto;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CardFactory {

    private UserService userService;

    public Card createCard(CardDto cardDto) {

        Card c = new Card();

        User u = userService.findByIdUser(cardDto.getUserId());
        c.setUser(u);
        c.setCardNo(cardDto.getCardNo());
        c.setCcv(cardDto.getCcv());
        c.setExpireMonth(cardDto.getExpireMonth());
        c.setExpireYear(cardDto.getExpireYear());
        c.setNameOnCard(cardDto.getNameOnCard());

        return c;
    }

    public CardDto createCardDto(Card card) {

        CardDto c = new CardDto();

        c.setCardNo(card.getCardNo());
        c.setCcv(card.getCcv());
        c.setExpireMonth(card.getExpireMonth());
        c.setExpireYear(card.getExpireYear());
        c.setNameOnCard(card.getNameOnCard());
        c.setUserId(card.getUser().getId());
        c.setId(card.getId());

        return c;
    }

    public List<CardDto> createCardDto(List<Card> cards) {

        List<CardDto> cardDtos = new ArrayList<>();

        for (Card c : cards) {
            CardDto cardDto = createCardDto(c);
            cardDtos.add(cardDto);
        }
        return cardDtos;
    }

}

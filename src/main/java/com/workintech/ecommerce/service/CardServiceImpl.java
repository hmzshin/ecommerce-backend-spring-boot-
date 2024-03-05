package com.workintech.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.workintech.ecommerce.exception.ConflictException;
import com.workintech.ecommerce.exception.NotExistException;
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
        var card = cardRepository.findByCardNo(cardDto.getCardNo());
        if (card.isPresent()) {
            if (card.get().getUser().getId().equals(cardDto.getUserId())) {
                throw new ConflictException("This card is already saved.");
            }
        }
        EntityValidations.isCardCredentialsValid(cardDto);
        Card c = cardFactory.createCard(cardDto);
        Card saved = cardRepository.save(c);
        return cardFactory.createCardDto(saved);
    }

    @Override
    public CardDto delete(CardDto card, Long userId) {
        if (!userId.equals(card.getUserId())) {
            throw new ConflictException("The id given in the path is not same with given in the body");
        }
        Card c = cardRepository.findByCardNo(card.getCardNo())
                .orElseThrow(() -> new NotExistException("Card", userId));
        if (c.getUser() == null) {
            throw new NotExistException("Card", userId);
        }
        c.setUser(null);
        Card cardUpdated = cardRepository.save(c);

        return cardFactory.createCardDto(cardUpdated);
    }

}

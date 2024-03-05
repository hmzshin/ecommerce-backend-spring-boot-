package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.workintech.ecommerce.dto.CardDto;
import com.workintech.ecommerce.service.CardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/card")
public class CardController {

    private CardService cardService;

    @GetMapping("/{userId}")
    public List<CardDto> findAllByUser(@PathVariable Long userId) {
        return cardService.findAllByUserId(userId);
    }

    @PostMapping
    public CardDto save(@RequestBody CardDto card) {
        return cardService.save(card);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public CardDto delete(@RequestBody CardDto cardDto, @PathVariable Long userId) {
        return cardService.delete(cardDto, userId);
    }

}

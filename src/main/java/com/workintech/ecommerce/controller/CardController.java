package com.workintech.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

package com.workintech.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.service.AddressService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/{userId}")
    public List<AddressDto> findAllByUser(@PathVariable Long userId) {
        return addressService.findAllByUser(userId);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto address) {
        return addressService.save(address);
    }

}

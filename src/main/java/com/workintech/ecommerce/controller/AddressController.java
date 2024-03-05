package com.workintech.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.service.AddressService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/{userId}")
    public List<AddressDto> findAllByUser(@PathVariable Long userId) {
        return addressService.findAllByUser(userId);
    }

    @PostMapping(path = "/save/{id}")
    public AddressDto save(@RequestBody AddressDto address, @PathVariable Long id) {
        return addressService.save(address, id);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public AddressDto delete(@RequestBody AddressDto addressDto, @PathVariable Long userId) {
        return addressService.delete(addressDto, userId);

    }

}

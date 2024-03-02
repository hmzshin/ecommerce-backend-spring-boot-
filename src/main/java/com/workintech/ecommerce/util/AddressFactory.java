package com.workintech.ecommerce.util;

import org.springframework.stereotype.Component;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AddressFactory {

    private UserService userService;

    public Address createAddress(AddressDto addressDto) {

        Address a = new Address();

        a.setAddress(addressDto.getAddress());
        a.setCity(addressDto.getCity());
        a.setDistrict(addressDto.getDistrict());
        a.setName(addressDto.getName());
        a.setNeighborhood(addressDto.getNeighborhood());
        a.setTitle(addressDto.getTitle());
        a.setSurname(addressDto.getSurname());
        a.setPhone(addressDto.getPhone());

        User u = userService.findByIdUser(addressDto.getUserId());
        a.setUser(u);

        return a;
    }

}

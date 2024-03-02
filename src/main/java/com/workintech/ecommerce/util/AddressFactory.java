package com.workintech.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

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

        User u = userService.findByIdUser(addressDto.getUserId());
        a.setUser(u);

        a.setAddress(addressDto.getAddress());
        a.setCity(addressDto.getCity());
        a.setDistrict(addressDto.getDistrict());
        a.setName(addressDto.getName());
        a.setNeighborhood(addressDto.getNeighborhood());
        a.setTitle(addressDto.getTitle());
        a.setSurname(addressDto.getSurname());
        a.setPhone(addressDto.getPhone());

        return a;
    }

    public AddressDto createAddressDto(Address address) {

        AddressDto a = new AddressDto();

        a.setAddress(address.getAddress());
        a.setCity(address.getCity());
        a.setDistrict(address.getDistrict());
        a.setName(address.getName());
        a.setNeighborhood(address.getNeighborhood());
        a.setTitle(address.getTitle());
        a.setSurname(address.getSurname());
        a.setPhone(address.getPhone());
        a.setUserId(address.getUser().getId());
        a.setId(address.getId());

        return a;
    }

    public List<AddressDto> createAddressDto(List<Address> addresses) {

        List<AddressDto> addressDtos = new ArrayList<>();

        for (Address a : addresses) {
            AddressDto addressDto = createAddressDto(a);
            addressDtos.add(addressDto);
        }

        return addressDtos;
    }

}

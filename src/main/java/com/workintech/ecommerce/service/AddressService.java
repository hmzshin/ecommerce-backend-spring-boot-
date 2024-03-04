package com.workintech.ecommerce.service;

import java.util.List;

import com.workintech.ecommerce.dto.AddressDto;
import com.workintech.ecommerce.entity.Address;

public interface AddressService {

    List<Address> findAll();

    List<AddressDto> findAllByUser(Long userId);

    Address findById(Long id);


    AddressDto save(AddressDto addressDto);

}